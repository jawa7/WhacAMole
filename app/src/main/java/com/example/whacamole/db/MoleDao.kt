package com.example.whacamole.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MoleDao {
    @Query("SELECT score FROM mole_table")
    suspend fun getScore(): Int

    @Query("INSERT INTO mole_table (score) VALUES (0)")
    suspend fun insertValue()

    @Update(entity = Mole::class)
    suspend fun updateScore(item: Mole)


}