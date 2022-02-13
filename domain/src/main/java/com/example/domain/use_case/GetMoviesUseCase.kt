package com.example.domain.use_case

import com.example.domain.MoviesRepository
import com.example.domain.entity.MovieStatus
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): MovieStatus = repository.fetchMovies()
}