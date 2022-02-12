package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.locale_data_source.MoviesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DbModule {

    companion object {
        private const val RUNNING_DATABASE_NAME = "movies_db"
    }

    @Singleton
    @Provides
    fun providesRunningDatabase(
        @ApplicationContext app: Context
    ): MoviesDataBase {
        return Room.databaseBuilder(
            app,
            MoviesDataBase::class.java,
            RUNNING_DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun dao(dataBase: MoviesDataBase) = dataBase.dao
}