package com.example.estudoconcurso

import android.app.Application
import com.example.estudoconcurso.di.appModule
import com.example.estudoconcurso.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AddressApplication : Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AddressApplication)
            modules(
                appModule,
                networkModule
            )
        }
    }
}