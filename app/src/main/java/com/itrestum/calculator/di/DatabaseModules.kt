package com.itrestum.calculator.di

import androidx.room.Room
import com.itrestum.calculator.AppDatabase
import org.koin.dsl.module

private const val DB_NAME = "history-db"
val databaseModules = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, DB_NAME).allowMainThreadQueries().build() }
    single { get<AppDatabase>().historyDao() }
}
