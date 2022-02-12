package com.example.ui_detail_feature

import com.example.domain.entity.MovieStatus
import com.example.domain.entity.MovieSuccess
import com.example.domain.use_case.GetMovieUseCase
import com.example.ui_detail_feature.model.DetailMovieUi
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : MvpPresenter<DetailView>() {

    fun getMovie(name: String) {
        presenterScope.launch {
            when (val status = getMovieUseCase.invoke(name)) {
                is MovieStatus.Success -> viewState.showMovie(status.movies.first().toDetail())
                is MovieStatus.Failure -> viewState.showError()
            }
        }
    }
}

private fun MovieSuccess.toDetail() =
    DetailMovieUi(
        description = description,
        id = id,
        imageUrl = imageUrl,
        localizedName = localizedName,
        name = name,
        rating = rating?.format(2) ?: "",
        year = year.toString()
    )

private fun Double.format(decimals: Int): String =
    String.format(Locale.ROOT, "%.0${decimals}f", this)