package com.example.data.locale_data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.locale_data_source.entity.FilmEntity

@Dao
interface MovieDao {

    @Insert
    suspend fun saveMovies(movies: List<FilmEntity>)

    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<FilmEntity>

    @Query("SELECT * FROM movies WHERE localizedName = :name")
    suspend fun getMovieByName(name: String): FilmEntity
}