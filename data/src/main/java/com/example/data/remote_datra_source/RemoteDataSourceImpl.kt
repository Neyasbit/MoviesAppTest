package com.example.data.remote_datra_source

import com.example.data.network.ApiDataSource
import com.example.data.network.entity.MoviesResponse
import com.example.data.remote_datra_source.models.ResponseWrapper
import com.example.data.repository.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(
    private val api: ApiDataSource,
) : RemoteDataSource {
    override suspend fun fetchFreshMovies(): ResponseWrapper<MoviesResponse> =
        safeCallApi { api.fetchMovies() }

    private inline fun <T> safeCallApi(apiCall: () -> Response<T>): ResponseWrapper<T> {
        return try {
            ResponseWrapper.success(apiCall.invoke())
        } catch (exception: Exception) {
            ResponseWrapper.failure(exception)
        }
    }
}