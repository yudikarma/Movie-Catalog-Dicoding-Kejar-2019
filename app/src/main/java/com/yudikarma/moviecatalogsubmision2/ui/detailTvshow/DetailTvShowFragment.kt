package com.yudikarma.moviecatalogsubmision2.ui.detailTvshow


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
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_tv_show.view.*
import org.jetbrains.anko.toast


class DetailTvShowFragment : BaseFragment() {
    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailTvShowViewModel::class.java)

        viewModel.data.observe(this, Observer {
            setupViewDetail(it)
            unvVisibleShimmer()
        })

    }

    lateinit var resultItemtvshow:ResultsItemTvShow
    lateinit var mView: View
    lateinit var viewModel: DetailTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_detail_tv_show, container, false)
        visibleShimmer()

        val safeVarargs :DetailTvShowFragmentArgs by navArgs()
        resultItemtvshow = safeVarargs.tvShow

        viewModel.data.value = resultItemtvshow

        mView.fab_addfav.setOnClickListener {
            viewModel.insertVaforiteTvShow(TvShowEntity(resultItemtvshow.first_air_date,
                resultItemtvshow.overview,resultItemtvshow.original_language,resultItemtvshow.poster_path,
                resultItemtvshow.backdrop_path,resultItemtvshow.original_name,resultItemtvshow.popularity,
                resultItemtvshow.vote_average,resultItemtvshow.name,resultItemtvshow.vote_count
                ))

            context.toast("Succes add to Favorite Movie")

        }


        return mView
    }


    fun setupViewDetail(resultsItem: ResultsItemTvShow) {
        var urlImage = "https://image.tmdb.org/t/p"
        Glide.with(this).load(urlImage+"/w500"+resultsItem.poster_path).into(mView.imageView)
        mView.textView.text = ""+resultsItem.name
        mView.textView2.text = ""+resultsItem.first_air_date
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
