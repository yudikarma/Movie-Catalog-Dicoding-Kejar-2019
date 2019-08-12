package com.yudikarma.moviecatalogsubmision2.feature.ui.detailMovie


import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.like.LikeButton
import com.like.OnLikeListener

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.widget.FavoriteMovieWIdget
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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



        mView.fab_addfav.setOnLikeListener(object :OnLikeListener{
            var movieEntity = MovieEntity(
                resultsItem.overview,resultsItem.original_language,resultsItem.title,resultsItem.poster_path,resultsItem.backdrop_path,
                resultsItem.release_date,resultsItem.vote_average,resultsItem.popularity,resultsItem.vote_count,true,resultsItem.id.toLong()
            )
            override fun liked(likeButton: LikeButton?) {
                viewModel.insertVaforiteMovie(movieEntity)

                updateWidgetFavoriteMovie()
                context.toast("Succes add to Favorite Movie")
            }

            override fun unLiked(likeButton: LikeButton?) {
                viewModel.deleteMovie(movieEntity)

                updateWidgetFavoriteMovie()
                context.toast("Succes Remove from Favorite Movie")

            }

        })


        return mView
    }

    private fun updateWidgetFavoriteMovie() {
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val thisWidget = ComponentName(context, FavoriteMovieWIdget::class.java!!)
        val appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget)
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.stack_view)
    }

    /*private fun updateWidgetFavoriteMovie() {
        val manager: AppWidgetManager = AppWidgetManager.getInstance(context)
        val view  = RemoteViews(context.packageName,R.layout.favorite_movie_widget)
        val componenName = ComponentName(context, FavoriteMovieWIdget::class.java)
        manager.updateAppWidget(componenName,view)
    }*/

     fun setupViewDetail(resultsItem: ResultsItem) {
         val urlImage = "https://image.tmdb.org/t/p"
         Glide.with(this).load(urlImage+"/w500"+resultsItem.poster_path).into(mView.imageView)
        mView.textView.text = ""+resultsItem.title
        mView.textView2.text = ""+resultsItem.release_date
        mView.description.text = ""+resultsItem.overview
         val rating = resultsItem.vote_average - 5.0
        mView.ratingBar.rating = rating.toFloat()

         //Log.d("isfavorite",""+viewModel.getFavoriteCOunt(resultsItem.id.toLong()))

         GlobalScope.launch {

             mView.fab_addfav.isLiked = viewModel.getFavoriteCOunt(resultsItem.id.toLong()) != 0
         }
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
