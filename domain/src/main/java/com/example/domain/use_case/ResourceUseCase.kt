package com.example.domain.use_case

import androidx.annotation.StringRes
import com.example.domain.MoviesRepository
import javax.inject.Inject

class ResourceUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(@StringRes id: Int): String =
        repository.getString(id)
}