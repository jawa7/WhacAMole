package com.example.whacamole.di

import com.example.whacamole.MoleRepository
import com.example.whacamole.db.MoleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMoleRepository(
        moleDao: MoleDao
    ) : MoleRepository = MoleRepository(moleDao)
}