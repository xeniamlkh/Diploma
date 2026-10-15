import androidx.room3.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.databasemodule.db.DictionaryDao
import com.example.databasemodule.db.DictionaryDatabase
import com.example.databasemodule.domain.WordItem
import com.example.databasemodule.repo.DictionaryRepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContains

class DictionaryRepositoryTest {
    private lateinit var db: DictionaryDatabase
    private lateinit var dao: DictionaryDao
    private lateinit var repo: DictionaryRepositoryImpl

    @BeforeTest
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder<DictionaryDatabase>()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
        dao = db.getDao()
        repo = DictionaryRepositoryImpl(dao)
    }

    @AfterTest
    fun tearDown() = db.close()

    @Test
    fun insertedWordIsInTable() = runTest {
        val wordItem = WordItem(
            word = "rabbit",
            translation = "кролик",
            example = "Tom saw some rabbits in his backyard."
        )

        val wordItemTwo = WordItem(
            word = "book",
            translation = "книга",
            example = "I bought the book the movie is based on."
        )

        repo.addWord(wordItem)
        repo.addWord(wordItemTwo)

        val words = repo.getWords().first()

        assertContains(words, wordItem)
        assertContains(words, wordItemTwo)
        assertEquals(2, words.size)
    }
}
