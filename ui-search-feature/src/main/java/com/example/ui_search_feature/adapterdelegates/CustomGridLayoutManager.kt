package com.example.ui_search_feature.adapterdelegates

import androidx.recyclerview.widget.GridLayoutManager
import com.example.ui_search_feature.SearchScreenAdapter

class CustomSpanSizeLookup(private val adapter: SearchScreenAdapter) :
    GridLayoutManager.SpanSizeLookup() {
    companion object {
        private const val MOVIE_VIEW_TYPE = 3
    }
    override fun getSpanSize(position: Int): Int {
        return if (adapter.getItemViewType(position) == MOVIE_VIEW_TYPE) 1 else 2
    }
}