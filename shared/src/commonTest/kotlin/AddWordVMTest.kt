import com.example.diploma.ui.addingWords.AddWordViewModel
import fakes.FakeDictionaryRepository
import fakes.FakeTatoebaApi
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import java.io.IOException
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class AddWordVMTest {
    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterTest
    fun tearDown() = Dispatchers.resetMain()

    private lateinit var repo: FakeDictionaryRepository
    private lateinit var api: FakeTatoebaApi

    private fun createViewModel(): AddWordViewModel {
        repo = FakeDictionaryRepository()
        api = FakeTatoebaApi()
        return AddWordViewModel(repo, api)
    }

    @Test
    fun fieldChangesUpdateState() = runTest {
        val vm = createViewModel()

        vm.onWordChange("rabbit")
        vm.onTranslationChange("кролик")
        vm.onExampleChange("Tom saw a rabbit.")

        with(vm.state.value) {
            assertEquals("rabbit", word)
            assertEquals("кролик", translation)
            assertEquals("Tom saw a rabbit.", example)
        }
    }

    @Test
    fun onWordFocusEndedLoadsExampleForCurrentWord() = runTest {
        val vm = createViewModel()
        api.result = { "Tom saw some rabbits in his backyard." }
        vm.onWordChange("rabbit")

        vm.onWordFocusEnded()
        val state = vm.state.first { it.example.isNotEmpty() }

        assertEquals("Tom saw some rabbits in his backyard.", state.example)
        assertFalse(state.isExampleError)
        assertEquals(listOf("rabbit"), api.requestedWords)
    }

    @Test
    fun onWordFocusEndedSetsErrorWhenApiFails() = runTest {
        val vm = createViewModel()
        api.result = { throw IOException("No network") }
        vm.onWordChange("rabbit")

        vm.onWordFocusEnded()
        val state = vm.state.first { it.isExampleError }

        assertTrue(state.isExampleError)
        assertEquals("", state.example)
    }

    @Test
    fun errorIsClearedAfterSuccessfulRetry() = runTest {
        val vm = createViewModel()
        vm.onWordChange("rabbit")

        api.result = { throw IOException("offline") }
        vm.onWordFocusEnded()
        vm.state.first { it.isExampleError }

        api.result = { "Tom saw a rabbit." }
        vm.onWordFocusEnded()
        val state = vm.state.first { it.example == "Tom saw a rabbit." }

        assertFalse(state.isExampleError)
    }

    @Test
    fun areWordFormsClearAfterWordIsSaved() = runTest {
        val vm = createViewModel()
        vm.onWordChange("rabbit")
        vm.onTranslationChange("кролик")
        vm.onExampleChange("Tom saw a rabbit.")

        vm.addWord()

        with(vm.state.value) {
            assertEquals("", word)
            assertEquals("", translation)
            assertEquals("", example)
            assertTrue(wordIsSaved)
        }
    }

    @Test
    fun changingWordAfterSaveResetsSavedFlag() = runTest {
        val vm = createViewModel()

        vm.onWordChange("rabbit")
        vm.addWord()

        assertTrue(vm.state.value.wordIsSaved)

        vm.onWordChange("book")

        assertFalse(vm.state.value.wordIsSaved)
    }

    @Test
    fun onBackClickDisablesSnackBarAndResetsSavedFlag() = runTest {
        val vm = createViewModel()
        vm.onWordChange("rabbit")
        vm.addWord()

        vm.onBackClick()

        assertTrue(vm.state.value.disableSnackBar)
        assertFalse(vm.state.value.wordIsSaved)
    }
}