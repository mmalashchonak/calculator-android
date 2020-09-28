package com.itrestum.calculator

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM hist")
    suspend fun getAll(): List<History>

    @Insert
    suspend fun insertAll(vararg histories: History)

    @Query("DELETE FROM hist")
    suspend fun deleteAll()
}