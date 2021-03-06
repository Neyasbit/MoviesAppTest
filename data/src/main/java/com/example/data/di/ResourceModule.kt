package com.example.data.di

import android.content.Context
import com.example.data.resource.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ResourceModule {

    @Singleton
    @Provides
    fun resource(@ApplicationContext context: Context): ResourceProvider =
        ResourceProvider.Base(context)
}