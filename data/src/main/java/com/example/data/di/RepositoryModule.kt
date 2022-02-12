package com.example.data.di

import com.example.data.repository.RepositoryImpl
import com.example.domain.Repository
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
    fun bindsRepository(repository: RepositoryImpl): Repository
}