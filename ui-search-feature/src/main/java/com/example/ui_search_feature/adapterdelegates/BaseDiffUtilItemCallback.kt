package com.example.ui_search_feature.adapterdelegates

import androidx.recyclerview.widget.DiffUtil
import com.example.ui_search_feature.model.DisplayableItem
import timber.log.Timber


class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<DisplayableItem>() {
    override fun areItemsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean {
        Timber.e("call")
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: DisplayableItem, newItem: DisplayableItem): Boolean {
        Timber.e("call")
        return oldItem.equals(newItem)
    }

    override fun getChangePayload(oldItem: DisplayableItem, newItem: DisplayableItem): Any? {
        if (oldItem.itemId != newItem.itemId)
            return getChangePayload(oldItem, newItem)
        return super.getChangePayload(oldItem, newItem)
    }
}