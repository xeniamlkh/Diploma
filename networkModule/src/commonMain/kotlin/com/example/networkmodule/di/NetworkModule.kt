package com.example.networkmodule.di

import com.example.networkmodule.TatoebaApi
import com.example.networkmodule.domain.ITatoebaApi
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::TatoebaApi) {
        bind<ITatoebaApi>()
    }
}