package com.example.data.network

import com.example.data.network.entity.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiDataSource {
    @GET("films.json")
    suspend fun fetchMovies() : Response<MoviesResponse>
}