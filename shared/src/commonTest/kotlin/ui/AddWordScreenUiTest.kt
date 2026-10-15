package ui

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.v2.runComposeUiTest
import com.example.databasemodule.domain.WordItem
import com.example.diploma.ui.addingWords.AddWordScreenTestTags
import fakes.FakeDictionaryRepository
import fakes.FakeTatoebaApi
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class AddWordScreenUiTest {

    @Test
    fun userFillsFormAndSavesWord() = runComposeUiTest {
        val repo = FakeDictionaryRepository()
        val api = FakeTatoebaApi()

        setAppContent(repo, api)

        onNodeWithTag(AddWordScreenTestTags.SCREEN_NAME).assertIsDisplayed()

        onNodeWithTag(AddWordScreenTestTags.WORD_TEXT_FIELD).performTextInput("rabbit")

        onNodeWithTag(AddWordScreenTestTags.TRANSLATION_TEXT_FIELD).performClick()

        waitUntil(timeoutMillis = 5_000) {
            onAllNodes(
                hasTestTag(AddWordScreenTestTags.EXAMPLE_TEXT_FIELD) and
                        hasText("Tom saw some rabbits in his backyard.")
            ).fetchSemanticsNodes().isNotEmpty()
        }

        onNodeWithTag(AddWordScreenTestTags.TRANSLATION_TEXT_FIELD).performTextInput("кролик")
        onNodeWithTag(AddWordScreenTestTags.SAVE_BUTTON).performClick()

        waitUntil(timeoutMillis = 5_000) { repo.words.value.isNotEmpty() }
        assertEquals(
            listOf(
                WordItem(
                    word = "rabbit",
                    translation = "кролик",
                    example = "Tom saw some rabbits in his backyard."
                )
            ),
            repo.words.value
        )

        onNodeWithTag(AddWordScreenTestTags.WORD_TEXT_FIELD).assert(!hasText("rabbit"))
    }

    @Test
    fun networkFailureShowsErrorButWordCanStillBeSaved() = runComposeUiTest {
        val repo = FakeDictionaryRepository()
        val api = FakeTatoebaApi().apply { result = { throw IOException("No network") } }
        setAppContent(repo, api)

        onNodeWithTag(AddWordScreenTestTags.WORD_TEXT_FIELD).performTextInput("rabbit")
        onNodeWithTag(AddWordScreenTestTags.TRANSLATION_TEXT_FIELD).performClick()

        waitUntil(timeoutMillis = 5_000) {
            onAllNodesWithTag(AddWordScreenTestTags.TRANSLATION_ERROR)
                .fetchSemanticsNodes().isNotEmpty()
        }

        onNodeWithTag(AddWordScreenTestTags.TRANSLATION_TEXT_FIELD).performTextInput("кролик")
        onNodeWithTag(AddWordScreenTestTags.SAVE_BUTTON).performClick()

        waitUntil(timeoutMillis = 5_000) { repo.words.value.isNotEmpty() }
        val saved = repo.words.value.single()
        assertEquals("rabbit", saved.word)
        assertEquals("кролик", saved.translation)
        assertEquals("", saved.example)
    }
}