package com.example.whacamole.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Mole::class], version = 1)
        abstract class MoleDatabase: RoomDatabase() {
            abstract fun moleDao(): MoleDao
        }