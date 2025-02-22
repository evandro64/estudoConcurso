package com.example.estudoconcurso.di

import com.example.estudoconcurso.repositories.AddressRepository
import com.example.estudoconcurso.repositories.UserRepository
import com.example.estudoconcurso.ui.viewModels.AddressViewModel
import com.example.estudoconcurso.ui.viewModels.UserViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val  appModule = module {
    singleOf(::AddressRepository)
    viewModelOf(::AddressViewModel)
}

val userModule = module {
    singleOf(::UserRepository)
    singleOf(::UserViewModel)
}

val networkModule = module {
    single {
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}