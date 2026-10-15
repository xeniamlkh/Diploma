
import com.example.databasemodule.domain.WordItem
import com.example.diploma.ui.cards.WordCardsScreenViewModel
import fakes.FakeDictionaryRepository
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class WordCardsScreenVMTest {
    private val rabbit =
        WordItem(word = "rabbit", translation = "кролик", example = "Tom saw some rabbits.")
    private val book =
        WordItem(word = "book", translation = "книга", example = "I bought the book.")
    private val house =
        WordItem(word = "house", translation = "дом", example = "This is my house.")

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterTest
    fun tearDown() = Dispatchers.resetMain()

    private fun createViewModel(
        words: List<WordItem> = emptyList()
    ): Pair<WordCardsScreenViewModel, FakeDictionaryRepository> {
        val repo = FakeDictionaryRepository(words)
        return WordCardsScreenViewModel(repo) to repo
    }

    @Test
    fun loadsWordsFromRepositoryAndStartsAtFirstCard() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))

        assertEquals(listOf(rabbit, book), vm.state.value.words)
        assertEquals(0, vm.state.value.currentIndex)
        assertFalse(vm.state.value.isFlipped)
    }

    @Test
    fun nextMovesToNextCardAndResetsFlip() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book, house))
        vm.onFlipChange(true)

        vm.onCurrentIndexChange()

        assertEquals(1, vm.state.value.currentIndex)
        assertFalse(vm.state.value.isFlipped)
    }

    @Test
    fun nextOnLastCardDoesNothing() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))
        vm.onCurrentIndexChange()
        vm.onFlipChange(true)

        vm.onCurrentIndexChange()

        assertEquals(1, vm.state.value.currentIndex)
        assertTrue(vm.state.value.isFlipped)
    }

    @Test
    fun previousMovesBackAndResetsFlip() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))
        vm.onCurrentIndexChange()
        vm.onFlipChange(true)

        vm.onPreviousIndexChange()

        assertEquals(0, vm.state.value.currentIndex)
        assertFalse(vm.state.value.isFlipped)
    }

    @Test
    fun previousOnFirstCardDoesNothing() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))
        vm.onFlipChange(true)

        vm.onPreviousIndexChange()

        assertEquals(0, vm.state.value.currentIndex)
        assertTrue(vm.state.value.isFlipped)
    }

    @Test
    fun flipChangeUpdatesState() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit))

        vm.onFlipChange(true)
        assertTrue(vm.state.value.isFlipped)

        vm.onFlipChange(false)
        assertFalse(vm.state.value.isFlipped)
    }

    @Test
    fun indexIsCoercedWhenWordListShrinks() = runTest {
        val (vm, repo) = createViewModel(listOf(rabbit, book, house))
        vm.onCurrentIndexChange()
        vm.onCurrentIndexChange()

        repo.words.value = listOf(rabbit)

        assertEquals(0, vm.state.value.currentIndex)
        assertEquals(listOf(rabbit), vm.state.value.words)
    }
}