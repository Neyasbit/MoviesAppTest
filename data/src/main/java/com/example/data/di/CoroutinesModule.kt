package com.example.data.di

import com.example.data.coroutines.CoroutineWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatcher() = CoroutineWrapper(
        io = Dispatchers.IO,
        main = Dispatchers.Main,
        computation = Dispatchers.Default
    )
}