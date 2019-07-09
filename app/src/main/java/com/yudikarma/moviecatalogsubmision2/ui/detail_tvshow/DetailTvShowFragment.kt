package com.yudikarma.moviecatalogsubmision2.ui.detail_tvshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.android.synthetic.main.fragment_detail_tv_show.view.*


class DetailTvShowFragment : Fragment() {

    lateinit var resultItemtvshow:ResultsItemTvShow
    lateinit var mView: View
    lateinit var viewModel: DetailTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail_tv_show, container, false)

        val safeVarargs :DetailTvShowFragmentArgs by navArgs()
        resultItemtvshow = safeVarargs.tvShow

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(DetailTvShowViewModel::class.java)
            viewModel.data.value = resultItemtvshow
            viewModel.data.observe(this, Observer {
                setupViewDetail(it)
            })
        }


        return mView
    }


    fun setupViewDetail(resultsItem: ResultsItemTvShow) {
        var urlImage = "https://image.tmdb.org/t/p"
        Glide.with(this).load(urlImage+"/w500"+resultsItem.poster_path).into(mView.imageView)
        mView?.textView.text = ""+resultsItem.name
        mView?.textView2.text = ""+resultsItem.first_air_date
        mView?.description.text = ""+resultsItem.overview
        val rating = resultsItem.vote_average - 5.0
        mView?.ratingBar.rating = rating.toFloat()
    }


}
