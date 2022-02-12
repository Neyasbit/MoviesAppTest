package com.example.data.coroutines

import kotlinx.coroutines.CoroutineDispatcher

data class CoroutineWrapper(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)