package com.example.data.di

import com.example.data.BuildConfig
import com.example.data.network.ApiDataSource
import com.example.data.remote_datra_source.RemoteDataSourceImpl
import com.example.data.repository.RemoteDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/sequeniatesttask/"

@InstallIn(SingletonComponent::class)
@Module
object NetWorkModule {

    @Singleton
    @Provides
    fun client(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            .build()

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun kotlinConverter(): Converter.Factory =
        Json.asConverterFactory("application/json".toMediaType())

    @Singleton
    @Provides
    fun api(kotlinConverter: Converter.Factory, client: OkHttpClient): ApiDataSource =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(kotlinConverter)
            .build()
            .create(ApiDataSource::class.java)

    @Singleton
    @Provides
    fun remoteDataSource(api: ApiDataSource): RemoteDataSource =
        RemoteDataSourceImpl(api)
}