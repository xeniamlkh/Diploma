import com.example.databasemodule.domain.WordItem
import com.example.diploma.ui.main.MainScreenViewModel
import fakes.FakeDictionaryRepository
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class MainScreenVMTest {
    private val rabbit =
        WordItem(word = "rabbit", translation = "кролик", example = "Tom saw some rabbits.")
    private val book =
        WordItem(word = "book", translation = "книга", example = "I bought the book.")
    private val house = WordItem(word = "house", translation = "дом", example = "This is my house.")

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterTest
    fun tearDown() = Dispatchers.resetMain()

    private fun createViewModel(
        words: List<WordItem> = emptyList()
    ): Pair<MainScreenViewModel, FakeDictionaryRepository> {
        val repo = FakeDictionaryRepository(words)
        return MainScreenViewModel(repo) to repo
    }

    @Test
    fun initialStateIsEmptyWhenRepositoryIsEmpty() = runTest {
        val (vm, _) = createViewModel()

        assertTrue(vm.state.value.words.isEmpty())
    }

    @Test
    fun loadsWordsFromRepositoryOnInit() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))

        assertEquals(listOf(rabbit, book), vm.state.value.words)
    }

    @Test
    fun stateUpdatesWhenRepositoryEmitsNewWords() = runTest {
        val (vm, repo) = createViewModel(listOf(rabbit))

        repo.words.value = listOf(rabbit, book, house)

        assertEquals(listOf(rabbit, book, house), vm.state.value.words)
    }

    @Test
    fun deletedWordRemovedFromTable() = runTest {
        val (vm, repo) = createViewModel(listOf(rabbit, book))

        vm.deleteWord(book)

        val words = repo.getWords().first()

        assertEquals(listOf(rabbit), words)
    }

    @Test
    fun deletedWordDisappearsFromState() = runTest {
        val (vm, _) = createViewModel(listOf(rabbit, book))

        vm.deleteWord(rabbit)

        assertEquals(listOf(book), vm.state.value.words)
    }
}