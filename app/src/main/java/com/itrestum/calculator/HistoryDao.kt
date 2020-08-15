package com.itrestum.calculator

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM hist")
    fun getAll(): List<History>

    @Query("SELECT * FROM hist WHERE uid IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<History>

    @Query("SELECT * FROM hist WHERE saved_value LIKE :value LIMIT 1")
    fun findByName(value: String): History

    @Insert
    fun insertAll(vararg histories: History)

    @Delete
    fun delete(history: History)

    @Query("DELETE FROM hist")
    suspend fun deleteAll()
}