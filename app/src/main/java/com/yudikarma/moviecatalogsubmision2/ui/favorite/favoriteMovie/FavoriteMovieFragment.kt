package com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteMovie


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.*
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.container_shimmer
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.recycleview_listmovie
import kotlinx.android.synthetic.main.fragment_fragment_list_movie.view.*
import org.jetbrains.anko.toast


class FavoriteMovieFragment : BaseFragment(), FavoriteMovieAdapter.OnItemClickListener {
    override fun onItemDeleteClick(v: View, movieEntity: MovieEntity) {
        model.deleteMovie(movieEntity)
        adapter.notifyDataSetChanged()
        context.toast("Succes delete item")

    }

    override fun setupViewModel() {

        model = ViewModelProviders.of(this,viewModelFactory).get(FavoriteMovieViewModel::class.java)

        model.data.observe(this, Observer {
            data.clear()
            data.addAll(it)
            adapter.notifyDataSetChanged()
            unvVisibleShimmer()
        })

    }

    lateinit var mView :View
    private lateinit var adapter : FavoriteMovieAdapter
    private lateinit var data:MutableList<MovieEntity>
    private lateinit var mContext: Context
    private lateinit var model: FavoriteMovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_favorite_movie, container, false)

        mContext = context

        visibleShimmer()
        model.getAllFavoriteMovie()
        setupRecycleView()
        return mView
    }

    private fun setupRecycleView() {
        data  = arrayListOf()
        adapter = FavoriteMovieAdapter(mContext,data,this)
        mView.recycleview_listmovie.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listmovie.adapter = adapter

    }
    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
    }



}
