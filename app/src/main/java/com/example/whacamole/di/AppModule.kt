package com.example.whacamole.di

import android.content.Context
import androidx.room.Room
import com.example.whacamole.BaseApplication
import com.example.whacamole.db.MoleDao
import com.example.whacamole.db.MoleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Provides
    fun provideMoleDao(appDatabase: MoleDatabase): MoleDao {
        return appDatabase.moleDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MoleDatabase {
        return Room.databaseBuilder(
            appContext,
            MoleDatabase::class.java,
            "mole_database"
        ).build()
    }
}