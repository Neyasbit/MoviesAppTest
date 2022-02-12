package com.example.data.network.entity

import com.example.data.locale_data_source.entity.FilmEntity
import com.example.domain.entity.MovieSuccess
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("films")
    val movies: List<Film>
)

@Serializable
data class Film(
    @SerialName("description")
    private val description: String? = null,
    @SerialName("genres")
    private val genres: List<String>,
    @SerialName("id")
    private val id: Int,
    @SerialName("image_url")
    private val imageUrl: String? = null,
    @SerialName("localized_name")
    private val localizedName: String,
    @SerialName("name")
    private val name: String,
    @SerialName("rating")
    private val rating: Double? = null,
    @SerialName("year")
    private val year: Int
) {
    fun toMovieSuccess() = MovieSuccess(
        description = description,
        genres = genres,
        id = id,
        imageUrl = imageUrl,
        localizedName = localizedName,
        name = name,
        rating = rating,
        year = year
    )

    fun toFilmDb() = FilmEntity(
        description = description,
        genres = genres,
        id = id,
        imageUrl = imageUrl,
        localizedName = localizedName,
        name = name,
        rating = rating,
        year = year
    )
}