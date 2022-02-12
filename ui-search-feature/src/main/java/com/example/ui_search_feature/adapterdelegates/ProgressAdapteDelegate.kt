package com.example.ui_search_feature.adapterdelegates

import com.example.ui_search_feature.databinding.ItemLayoutProgressBinding
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun progressAdapterDelegate() =
    adapterDelegateViewBinding<MovieUI.Progress, DisplayableItem, ItemLayoutProgressBinding>(
        { layoutInflater, root -> ItemLayoutProgressBinding.inflate(layoutInflater, root, false) }
    ) {}
