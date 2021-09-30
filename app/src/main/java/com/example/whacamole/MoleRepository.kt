package com.example.whacamole

import androidx.annotation.WorkerThread
import com.example.whacamole.db.Mole
import com.example.whacamole.db.MoleDao

class MoleRepository (private val moleDao: MoleDao) {

    suspend fun moleScore() = moleDao.getScore()

    suspend fun insertValues() = moleDao.insertValue()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(item: Mole) {
        moleDao.updateScore(item)
    }
}