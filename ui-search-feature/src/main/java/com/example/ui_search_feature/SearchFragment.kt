package com.example.ui_search_feature

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.BaseFragment
import com.example.navigation.NavigationFlow
import com.example.ui_search_feature.adapterdelegates.CustomSpanSizeLookup
import com.example.ui_search_feature.databinding.FragmentSearchBinding
import com.example.ui_search_feature.model.MovieUI
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
), SearchView {

    @Inject
    lateinit var presenterProvider: Provider<SearchPresenter>

    private val presenter: SearchPresenter by moxyPresenter { presenterProvider.get() }

    private val adapter = SearchScreenAdapter(
        onGenreClick = { genre, position ->
            presenter.getMoviesByGenre(genre, position)
        },
        onTryClick = { presenter.onRefresh() },
        onMoviesClick = { name ->
            navigator.navigateToFlow(NavigationFlow.DetailFlow(name))
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rv.adapter = adapter
            rv.setHasFixedSize(true)
        }
    }

    override fun showMovies(movies: List<MovieUI>) {
        settingManager()
        adapter.items = movies
    }

    override fun showProgress(isProgress: Boolean) {
        if (isProgress)
            adapter.items = listOf(MovieUI.Progress)
    }


    override fun showError(error: MovieUI.Error) {
        adapter.items = listOf(error)
    }

    private fun settingManager() {
        val manager = GridLayoutManager(requireContext(), 2)
        manager.spanSizeLookup = CustomSpanSizeLookup(adapter)
        binding.rv.layoutManager = manager
    }
}


