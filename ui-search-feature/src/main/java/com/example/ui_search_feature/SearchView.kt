package com.example.ui_search_feature

import com.example.ui_search_feature.model.MovieUI
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface SearchView : MvpView {

    @AddToEndSingle
    fun showError(error: MovieUI.Error)

    @AddToEndSingle
    fun showMovies(movies: List<MovieUI>)

    @AddToEndSingle
    fun showProgress(isProgress: Boolean)

}