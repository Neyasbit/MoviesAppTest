package com.example.data.remote_datra_source.models

import retrofit2.Response

data class ResponseWrapper<T>(
    val status: Status?,
    val data: Response<T>?,
    val exception: Exception?
) {
    companion object {
        fun <T> success(data: Response<T>): ResponseWrapper<T> =
            ResponseWrapper(
                status = Status.Success,
                data = data,
                exception = null
            )

        fun <T> failure(exception: Exception): ResponseWrapper<T> =

            ResponseWrapper(
                status = Status.Failed,
                data = null,
                exception = exception
            )
    }

    sealed class Status {
        object Success : Status()
        object Failed : Status()
    }

    val failed: Boolean
        get() = this.status == Status.Failed

    val isSuccessful
        get() = !failed && this.data?.isSuccessful == true

    val body : T
        get() = this.data!!.body()!!

}