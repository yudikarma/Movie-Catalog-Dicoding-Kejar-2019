package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie


import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.widget.FavoriteMovieWIdget
import com.yudikarma.moviecatalogsubmision2.utils.SpannedGridLayoutManager
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.*
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.container_shimmer
import kotlinx.android.synthetic.main.fragment_favorite_movie.view.recycleview_listmovie
import org.jetbrains.anko.toast


class FavoriteMovieFragment : BaseFragment(), FavoriteMovieAdapter.OnItemClickListener {
    override fun onItemDeleteClick(v: View, movieEntity: MovieEntity) {
        model.deleteMovie(movieEntity)
        adapter.notifyDataSetChanged()
        context.toast("Succes delete item")

        updateWidgetFavoriteMovie()

    }

    override fun setupViewModel() {

        model = ViewModelProviders.of(this,viewModelFactory).get(FavoriteMovieViewModel::class.java)

        model.data.observe(this, Observer {
            data.clear()
            data.addAll(it)
            adapter.notifyDataSetChanged()
            unvVisibleShimmer()

            if (adapter.itemCount == 0) visibleNoData() else UnVisibleNoData()

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

        mView.recycleview_listmovie.setHasFixedSize(true)
        mView.recycleview_listmovie.layoutManager = LinearLayoutManager(context)
        mView.recycleview_listmovie.adapter = adapter

    }
    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
    }
    fun visibleNoData(){
        mView.no_data_fvorite_movie.visibility = View.VISIBLE
    }

    fun UnVisibleNoData(){
        mView.no_data_fvorite_movie.visibility = View.GONE
    }

    private fun updateWidgetFavoriteMovie() {
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val thisWidget = ComponentName(context, FavoriteMovieWIdget::class.java!!)
        val appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget)
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.stack_view)
    }



}
