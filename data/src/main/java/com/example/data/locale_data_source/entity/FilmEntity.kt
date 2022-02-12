package com.example.data.locale_data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.MovieSuccess

@Entity(tableName = "movies")
data class FilmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String?,
    val imageUrl: String?,
    val localizedName: String,
    val genres: List<String>,
    val description: String?,
    val rating: Double?,
    val year: Int
) {
    fun toMovieSuccess() = MovieSuccess(
        description = description,
        genres = genres,
        id = id!!,
        imageUrl = imageUrl,
        localizedName = localizedName,
        name = name!!,
        rating = rating,
        year = year
    )
}