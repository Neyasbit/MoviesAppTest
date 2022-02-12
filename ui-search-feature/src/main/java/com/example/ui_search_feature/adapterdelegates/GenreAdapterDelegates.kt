package com.example.ui_search_feature.adapterdelegates

import com.example.ui_search_feature.R
import com.example.ui_search_feature.databinding.ItemLayoutGenreBinding
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun genreAdapterDelegate(itemClickedListener: (MovieUI.Genre, Int) -> Unit) =
    adapterDelegateViewBinding<MovieUI.Genre, DisplayableItem, ItemLayoutGenreBinding>(
        { layoutInflater, root -> ItemLayoutGenreBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.apply {
                titleGenre.text = item.title
                titleGenre.setBackgroundResource(if (item.isPressed) R.drawable.selected_genre_bg else R.drawable.rectangle_corners_bg)
                titleGenre.setOnClickListener {
                    itemClickedListener(item, bindingAdapterPosition)
                }
            }
        }
    }