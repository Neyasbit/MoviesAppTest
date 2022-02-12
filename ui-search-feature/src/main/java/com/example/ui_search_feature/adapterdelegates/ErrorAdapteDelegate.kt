package com.example.ui_search_feature.adapterdelegates

import com.example.ui_search_feature.databinding.ItemLayoutErrorsBinding
import com.example.ui_search_feature.model.DisplayableItem
import com.example.ui_search_feature.model.MovieUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun errorAdapterDelegate(onTry: () -> Unit) =
    adapterDelegateViewBinding<MovieUI.Error, DisplayableItem, ItemLayoutErrorsBinding>(
        { layoutInflater, root -> ItemLayoutErrorsBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.apply {
                errorHeading.text = item.message
                tryAgain.setOnClickListener { onTry() }
            }
        }
    }
