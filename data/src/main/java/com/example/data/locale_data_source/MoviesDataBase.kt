package com.example.data.locale_data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.locale_data_source.entity.FilmEntity

@Database(entities = [FilmEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenresConverter::class)
abstract class MoviesDataBase : RoomDatabase() {
    abstract val dao: MovieDao
}