package com.example.ui_search_feature.adapterdelegates

import androidx.recyclerview.widget.DiffUtil
import com.example.ui_search_feature.model.DisplayableItem


class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<DisplayableItem>() {
    override fun areItemsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem) =
        oldItem.itemId == newItem.itemId

    override fun areContentsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem) =
        oldItem.equals(newItem)
}