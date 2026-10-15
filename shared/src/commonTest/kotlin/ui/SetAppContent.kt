package ui

import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import com.example.diploma.App
import com.example.diploma.di.appModule
import di.uiTestModule
import fakes.FakeDictionaryRepository
import fakes.FakeTatoebaApi
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@OptIn(ExperimentalTestApi::class)
fun ComposeUiTest.setAppContent(
    repo: FakeDictionaryRepository = FakeDictionaryRepository(),
    api: FakeTatoebaApi = FakeTatoebaApi(),
) {
    setContent {
        KoinApplication(
            configuration = koinConfiguration(
                declaration = {
                    modules(
                        appModule,
                        uiTestModule(repo, api)
                    )
                }
            ),
            content = { App() }
        )
    }
}