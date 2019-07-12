package com.yudikarma.moviecatalogsubmision2.ui.detailMovie


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
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*
import org.jetbrains.anko.toast

class DetailMovieFragment : BaseFragment() {
    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailMovieViewModel::class.java)

        viewModel.data.observe(this, Observer {
            setupViewDetail(it)
            unvVisibleShimmer()
        })


    }

    lateinit var resultsItem:ResultsItem
    lateinit var mView: View

    lateinit var viewModel: DetailMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail_movie, container, false)

        visibleShimmer()
        val safeVarargs :DetailMovieFragmentArgs by navArgs()
        resultsItem = safeVarargs.movie
        viewModel.data.value = resultsItem



        mView.fab_addfav.setOnClickListener {
            viewModel.insertVaforiteMovie(MovieEntity(
                resultsItem.overview,resultsItem.original_language,resultsItem.title,resultsItem.poster_path,resultsItem.backdrop_path,
                resultsItem.release_date,resultsItem.vote_average,resultsItem.popularity,resultsItem.vote_count
            ))

            context.toast("Succes add to Favorite Movie")
        }


        return mView
    }

     fun setupViewDetail(resultsItem: ResultsItem) {
         var urlImage = "https://image.tmdb.org/t/p"
         Glide.with(this).load(urlImage+"/w500"+resultsItem.poster_path).into(mView.imageView)
        mView.textView.text = ""+resultsItem.title
        mView.textView2.text = ""+resultsItem.release_date
        mView.description.text = ""+resultsItem.overview
         val rating = resultsItem.vote_average - 5.0
        mView.ratingBar.rating = rating.toFloat()
    }
    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
        mView.appbar.visibility  = View.VISIBLE
        mView.nested_scrollitem.visibility = View.VISIBLE

    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
        mView.appbar.visibility  = View.GONE
        mView.nested_scrollitem.visibility = View.GONE
    }


}
