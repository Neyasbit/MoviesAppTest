package com.example.data.repository

import com.example.data.coroutines.CoroutineWrapper
import com.example.data.locale_data_source.MovieDao
import com.example.data.resource.ResourceProvider
import com.example.domain.MoviesRepository
import com.example.domain.entity.ErrorHolder
import com.example.domain.entity.MovieStatus
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dao: MovieDao,
    private val resource: ResourceProvider,
    private val dispatcher: CoroutineWrapper
) : MoviesRepository {

    override suspend fun fetchMovies(): MovieStatus =
        withContext(dispatcher.io) { fetchMoviesFromDb() }

    override suspend fun fetchMovieByName(name: String): MovieStatus =
        withContext(dispatcher.io) {
            MovieStatus.Success(listOf(dao.getMovieByName(name).toMovieSuccess()))
        }


    override fun getString(id: Int): String = resource.string(id)

    private suspend fun fetchMoviesFromDb(): MovieStatus {
        val moviesDb = dao.getMovies().map { it.toMovieSuccess() }

        return if (moviesDb.isNotEmpty())
            MovieStatus.Success(moviesDb)
        else
            fetchMoviesFromServer()
    }

    private suspend fun fetchMoviesFromServer(): MovieStatus {
        val request = remoteDataSource.fetchFreshMovies()

        if (request.failed)
            return MovieStatus.Failure(asNetworkException(request.exception!!))

        val movies = request.body.movies
        if (!request.isSuccessful)
            return MovieStatus.Empty

        dao.saveMovies(movies = movies.map { it.toFilmDb() })

        return MovieStatus.Success(movies = movies.map { it.toMovieSuccess() })
    }

    private fun asNetworkException(ex: Throwable): ErrorHolder {
        return when (ex) {
            is IOException -> ErrorHolder.NetworkConnection("No Internet Connection")
            is HttpException -> ErrorHolder.BadRequest("bad request")
            else -> ErrorHolder.UnExpected("Something went wrong...")
        }
    }
}