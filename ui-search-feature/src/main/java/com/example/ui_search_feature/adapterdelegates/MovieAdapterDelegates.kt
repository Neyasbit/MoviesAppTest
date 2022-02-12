package com.example.ui_search_feature.adapterdelegates

import com.example.core.utils.loadImage
import com.example.ui_search_feature.databinding.ItemLayoutMovieBinding
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun movieAdapterDelegate(onMoviesClick: (String) -> Unit) =
    adapterDelegateViewBinding<MovieUI.Movie, DisplayableItem, ItemLayoutMovieBinding>(
        { layoutInflater, root -> ItemLayoutMovieBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.apply {
                root.setOnClickListener { onMoviesClick(item.name) }
                movieTitle.text = item.name
                movieImg.loadImage(item.imageUrl)
            }
        }
    }