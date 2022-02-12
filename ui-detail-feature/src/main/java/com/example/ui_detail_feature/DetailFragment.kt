package com.example.ui_detail_feature

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.core.BaseFragment
import com.example.core.utils.loadImage
import com.example.ui_detail_feature.databinding.FragmentDetailBinding
import com.example.ui_detail_feature.model.DetailMovieUi
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
), DetailView {
    private val args by navArgs<DetailFragmentArgs>()

    @Inject
    lateinit var presenterProvider: Provider<DetailPresenter>

    private val detailPresenter: DetailPresenter by moxyPresenter { presenterProvider.get() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailPresenter.getMovie(args.dynamicTitle)
    }

    override fun showMovie(movie: DetailMovieUi) {
        binding.apply {
            movieImage.loadImage(movie.imageUrl)
            movieName.text = movie.name
            movieDes.text = movie.description
            movieYear.text = getString(R.string.year_title, movie.year)
            movieRating.text = getString(R.string.rating_title, movie.rating)
        }
    }

    override fun showError() {
        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
    }
}