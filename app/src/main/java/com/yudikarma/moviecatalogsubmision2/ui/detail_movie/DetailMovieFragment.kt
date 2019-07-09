package com.yudikarma.moviecatalogsubmision2.ui.detail_movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*

class DetailMovieFragment : Fragment() {

    lateinit var resultsItem:ResultsItem
    lateinit var mView: View

    lateinit var viewModel: DetailMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail_movie, container, false)

        val safeVarargs :DetailMovieFragmentArgs by navArgs()
        resultsItem = safeVarargs.movie

        activity?.let {
            viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel::class.java)
            viewModel.data.value = resultsItem
            viewModel.data.observe(this, Observer {
                setupViewDetail(it)
            })
        }


        return mView
    }

     fun setupViewDetail(resultsItem: ResultsItem) {
         var urlImage = "https://image.tmdb.org/t/p"
         Glide.with(this).load(urlImage+"/w500"+resultsItem.poster_path).into(mView.imageView)
        mView?.textView.text = ""+resultsItem.title
        mView?.textView2.text = ""+resultsItem.release_date
        mView?.description.text = ""+resultsItem.overview
         val rating = resultsItem.vote_average - 5.0
        mView?.ratingBar.rating = rating.toFloat()
    }


}
