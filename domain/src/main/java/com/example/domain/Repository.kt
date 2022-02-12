package com.example.domain

import androidx.annotation.StringRes
import com.example.domain.entity.MovieStatus

interface Repository {

    suspend fun fetchMovies(): MovieStatus

    suspend fun fetchMovieByName(name: String): MovieStatus

    fun getString(@StringRes id: Int): String
}