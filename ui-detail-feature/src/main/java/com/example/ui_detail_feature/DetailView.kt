package com.example.ui_detail_feature

import com.example.ui_detail_feature.model.DetailMovieUi
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution


interface DetailView : MvpView {

    @AddToEndSingle
    fun showMovie(movie: DetailMovieUi)

    @OneExecution
    fun showError()
}