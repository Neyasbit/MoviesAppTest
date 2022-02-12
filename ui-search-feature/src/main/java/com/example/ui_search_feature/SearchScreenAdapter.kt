package com.example.ui_search_feature

import com.example.ui_search_feature.adapterdelegates.*
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class SearchScreenAdapter(
    onGenreClick: (MovieUI.Genre, Int) -> Unit,
    onTryClick: () -> Unit,
    onMoviesClick: (String) -> Unit
) :
    AsyncListDifferDelegationAdapter<DisplayableItem>(BaseDiffUtilItemCallback()) {

    init {
        delegatesManager.addDelegate(errorAdapterDelegate(onTryClick))
        delegatesManager.addDelegate(genreAdapterDelegate(onGenreClick))
        delegatesManager.addDelegate(headerAdapterDelegate())
        delegatesManager.addDelegate(movieAdapterDelegate(onMoviesClick))
        delegatesManager.addDelegate(progressAdapterDelegate())
    }
}
