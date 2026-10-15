package di

import com.example.databasemodule.domain.IDictionaryRepository
import com.example.diploma.navigation.AddWordScreen
import com.example.diploma.navigation.Navigator
import com.example.networkmodule.domain.ITatoebaApi
import fakes.FakeDictionaryRepository
import fakes.FakeTatoebaApi
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module

@OptIn(KoinExperimentalAPI::class)
fun uiTestModule(
    repo: FakeDictionaryRepository,
    api: FakeTatoebaApi
) = module {
    single { Navigator(startDestination = AddWordScreen) }

    single<IDictionaryRepository> { repo }
    single<ITatoebaApi> { api }
}