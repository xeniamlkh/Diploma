import androidx.room3.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.databasemodule.db.DictionaryDao
import com.example.databasemodule.db.DictionaryDatabase
import com.example.databasemodule.db.WordEntity
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class DictionaryDaoTest {
    private lateinit var db: DictionaryDatabase
    private lateinit var dao: DictionaryDao

    @BeforeTest
    fun setUp() {
        db = Room.inMemoryDatabaseBuilder<DictionaryDatabase>()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
        dao = db.getDao()
    }

    @AfterTest
    fun tearDown() = db.close()

    @Test
    fun insertedWordCanBeReadBack() = runTest {
        val id = dao.insertWord(
            WordEntity(
                word = "rabbit",
                translation = "кролик",
                example = "Tom saw some rabbits in his backyard."
            )
        )

        val loaded = dao.getById(id)

        assertNotNull(loaded)
        assertEquals("rabbit", loaded.word)
        assertEquals("кролик", loaded.translation)
        assertEquals("Tom saw some rabbits in his backyard.", loaded.example)
    }
}