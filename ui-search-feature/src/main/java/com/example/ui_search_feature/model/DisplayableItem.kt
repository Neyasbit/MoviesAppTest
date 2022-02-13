package com.example.ui_search_feature.model

interface DisplayableItem {
    val itemId: Int
}

sealed class MovieUI : DisplayableItem {
    class Header(
        val name: String
    ) : MovieUI() {
        override val itemId: Int get() = name.hashCode()
    }

    class Movie(
        val id: Int,
        val name: String,
        val imageUrl: String
    ) : MovieUI() {
        override val itemId get() = id
    }

    data class Genre(
        val title: String,
        var isPressed: Boolean = false
    ) : MovieUI() {
        override val itemId get() = title.hashCode()
    }

    object Progress : MovieUI() {
        override val itemId: Int get() = hashCode()
    }

    class Error(
        val message: String
    ) : MovieUI() {
        override val itemId: Int
            get() = hashCode()
    }
}
