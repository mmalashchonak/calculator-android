package com.itrestum.calculator

import android.app.Application
import com.itrestum.calculator.di.databaseModules
import com.itrestum.calculator.di.repositoryModule
import com.itrestum.calculator.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CalculatorApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@CalculatorApplication)
            modules(
                listOf(viewModelModule, databaseModules, repositoryModule)
            )
        }
    }
}