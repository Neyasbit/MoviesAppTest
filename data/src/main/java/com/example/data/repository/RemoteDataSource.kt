package com.example.data.repository

import com.example.data.network.entity.MoviesResponse
import com.example.data.remote_datra_source.models.ResponseWrapper

interface RemoteDataSource {
    suspend fun fetchFreshMovies() : ResponseWrapper<MoviesResponse>
}