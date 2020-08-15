package com.itrestum.calculator.ui

import com.itrestum.calculator.History
import com.itrestum.calculator.HistoryDao

class MainRepository(private val dao: HistoryDao) {
    suspend fun onClearHistory() {
        dao.deleteAll()
    }

    suspend fun insertAll(history: History) {
        dao.insertAll(history)
    }

    suspend fun getAll() = dao.getAll()
}