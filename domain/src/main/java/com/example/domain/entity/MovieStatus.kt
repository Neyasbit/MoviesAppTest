package com.example.domain.entity


sealed class MovieStatus {
    data class Success(val movies: List<MovieSuccess>) : MovieStatus()
    data class Failure(val errorHandler: ErrorHolder) : MovieStatus()
    object Empty : MovieStatus()
}

sealed class ErrorHolder(message: String) : Throwable(message) {
    data class NetworkConnection(override val message: String) :
        ErrorHolder(message)

    data class BadRequest(override val message: String) :
        ErrorHolder(message)

    data class UnExpected(override val message: String) :
        ErrorHolder(message)
}

data class MovieSuccess(
    val description: String? = null,
    val genres: List<String>,
    val id: Int,
    val imageUrl: String? = null,
    val localizedName: String,
    val name: String,
    val rating: Double? = null,
    val year: Int
)




