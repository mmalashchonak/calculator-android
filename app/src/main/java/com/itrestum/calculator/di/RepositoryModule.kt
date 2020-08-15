package com.itrestum.calculator.di

import com.itrestum.calculator.ui.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get()) }
}