package com.example.ui_search_feature.adapterdelegates

import com.example.ui_search_feature.databinding.ItemLayoutHeaderBinding
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun headerAdapterDelegate() =
    adapterDelegateViewBinding<MovieUI.Header, DisplayableItem, ItemLayoutHeaderBinding>(
        { layoutInflater, root -> ItemLayoutHeaderBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.header.text = item.name
        }
    }