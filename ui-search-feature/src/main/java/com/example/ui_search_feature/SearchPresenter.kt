package com.example.ui_search_feature

import com.example.domain.entity.MovieStatus
import com.example.domain.entity.MovieSuccess
import com.example.domain.use_case.GetMoviesUseCase
import com.example.domain.use_case.ResourceUseCase
import com.example.ui_search_feature.model.MovieUI
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val resourceUseCase: ResourceUseCase
) : MvpPresenter<SearchView>() {

    private lateinit var moviesHolder: List<MovieSuccess>

    private val recyclerItems = mutableListOf<MovieUI>()
    private var movies = mutableListOf<MovieUI.Movie>()
    private val genres = mutableSetOf<MovieUI.Genre>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        fetchMoviesStatus()
    }


    fun getMoviesByGenre(genre: MovieUI.Genre, currentPosition: Int) {

        setGenrePressedStat(genre, currentPosition)
        replaceMovies(genre)

        viewState.showMovies(recyclerItems)
    }

    fun onRefresh() {
        fetchMoviesStatus()
    }

    private fun fetchMoviesStatus() {
        presenterScope.launch {
            viewState.showProgress(true)
            prepareMovies()
            viewState.showProgress(false)
        }
    }

    private suspend fun prepareMovies() {

        when (val status = getMoviesUseCase.invoke()) {
            is MovieStatus.Success -> {
                moviesHolder = status.movies
                viewState.showMovies(creteUiItems())
            }
            is MovieStatus.Failure ->
                viewState.showError(MovieUI.Error(status.errorHandler.localizedMessage))
        }
    }

    private fun creteUiItems(): List<MovieUI> {

        recyclerItems.add(MovieUI.Header(resourceUseCase.invoke(R.string.genre)))

        moviesHolder.forEach {
            movies.add(it.toMovie())
            it.genres.forEach { genre ->
                if (genre.isNotEmpty())
                    genres.add(MovieUI.Genre(genre))
            }
        }

        recyclerItems.addAll(genres)
        recyclerItems.add(MovieUI.Header(resourceUseCase.invoke(R.string.movies)))
        recyclerItems.addAll(movies)

        return recyclerItems
    }
    /*
        Да, я знаю. Что при большем количестве данных это надо реализовывать через поиск в базе.
        Но так как данных мало списки будут эффективнее.
     */

    private fun replaceMovies(genre: MovieUI.Genre) {
        recyclerItems.removeAll(movies)
        val filtratedMovies = moviesHolder.filter { it.genres.contains(genre.title) }
        val moviesUi = filtratedMovies.map { it.toMovie() }
        movies = moviesUi.toMutableList()
        recyclerItems.addAll(moviesUi)
    }

    private fun setGenrePressedStat(genre: MovieUI.Genre, currentPosition: Int) {
        genres.forEach {
            it.isPressed = false
        }
        genre.isPressed = true
        recyclerItems[currentPosition] = genre
    }
}

private fun MovieSuccess.toMovie() = MovieUI.Movie(
    id = id,
    imageUrl = imageUrl,
    name = localizedName,
)