package com.example.domain.use_case

import com.example.domain.Repository
import com.example.domain.entity.MovieStatus
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(name: String): MovieStatus =
        repository.fetchMovieByName(name)
}