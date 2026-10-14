
import com.example.networkmodule.rest.SentenceSearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TatoebaApiTest {
    private lateinit var client: HttpClient

    @BeforeTest
    fun setUp() {
        client = HttpClient {
            install(ContentNegotiation) {
                json(
                    Json { ignoreUnknownKeys = true }
                )
            }
        }
    }

    @AfterTest
    fun tearDown() = client.close()

    @Test
    fun fetchExampleReturnsSentenceAndCallsCorrectUrl() = runTest {
        val response: SentenceSearchResponse = client
            .get("https://api.tatoeba.org/v1/sentences") {
                parameter("lang", "eng")
                parameter("q", "rabbit")
                parameter("word_count", "5-10")
                parameter("sort", "relevance")
                parameter("limit", 1)
            }.body()

        val result = response.data.firstOrNull()?.text.orEmpty()

        assertEquals("They bought a pet rabbit.", result)
    }

    @Test
    fun fetchExampleReturnsFailureOnNetworkException() = runTest {
        val result = runCatching {
            client.get("https://api.tatoeba.org/v1/sentences") {
                throw IOException("No network")
            }
        }

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is IOException)
        assertEquals("No network", result.exceptionOrNull()?.message)
    }

    @Test
    fun fetchExampleReturnsInvalidValueCodeOnNotFound() = runTest {
        lateinit var responseStatus: HttpStatusCode

        runCatching {
            client.get("https://api.tatoeba.org/v1/sentences") {
                parameter("lang", "eng")
                parameter("q", "rabbit")
                parameter("word_count", "5-10")
                parameter("limit", 1)
            }
        }.onSuccess { response ->
            responseStatus = response.status
        }

        assertEquals("400", responseStatus.toString().trim())
    }
}