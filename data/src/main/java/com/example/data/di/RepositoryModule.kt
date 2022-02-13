package com.example.data.di

import com.example.data.repository.MoviesRepositoryImpl
import com.example.domain.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsRepository(repository: MoviesRepositoryImpl): MoviesRepository
}