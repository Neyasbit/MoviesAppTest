package com.example.domain.use_case

import androidx.annotation.StringRes
import com.example.domain.Repository
import javax.inject.Inject

class ResourceUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(@StringRes id: Int): String =
        repository.getString(id)
}