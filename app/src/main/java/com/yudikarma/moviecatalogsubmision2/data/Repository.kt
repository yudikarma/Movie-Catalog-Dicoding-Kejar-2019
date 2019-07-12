package com.yudikarma.moviecatalogsubmision2.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.yudikarma.moviecatalogsubmision2.BuildConfig
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.utils.ioThread

class Repository(private val apiHelper: ApiHelper,
                 private val appDatabase: AppDatabase,
                 private val context: Context) {

     fun getListMovies() = apiHelper.getListMovies(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

     fun getListTvShow() = apiHelper.getListTvShow(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

    fun insertFavoriteMovie(movieEntity: MovieEntity, inserted:() -> Unit) = ioThread {
        appDatabase.movieDao().insertMovie(movieEntity)
        inserted()
    }

    fun getALlFavoriteMovie():LiveData<List<MovieEntity>> = appDatabase.movieDao().getAllMovie()

    fun updateMovie(id:Long,vote_count:Int,popularity:Double, vote_average:Double,release_date:String, backdrop_path:String,poster_path:String,title:String,original_language:String,overview:String,
                    update: () -> Unit) = ioThread {
        appDatabase.movieDao().updateMovie(id,vote_count,popularity, vote_average,release_date, backdrop_path,poster_path,title,original_language,overview)
        update()
    }

    fun deleteMovie(movieEntity: MovieEntity, delete: () -> Unit) = ioThread {
        appDatabase.movieDao().deleteMovie(movieEntity)
        delete()
    }

    fun insertFavoriteTvShow(tvShowEntity: TvShowEntity, inserted:() -> Unit) = ioThread {
        appDatabase.tvShowDao().insertTvshow(tvShowEntity)
        inserted()
    }
    
    fun getALlFavoriteTvShow():LiveData<List<TvShowEntity>> = appDatabase.tvShowDao().getAllTVShow()

    fun updateTVShow(id:Long,first_air_date:String,overview:String, original_language:String,poster_path:String, backdrop_path:String,original_name:String,popularity:Double,vote_average:Double,name:String,vote_count:String,
                    update: () -> Unit) = ioThread {
        appDatabase.tvShowDao().updateTvshow(id,first_air_date,overview, original_language,poster_path, backdrop_path,original_name,popularity,vote_average,name,vote_count)
        update()
    }

    fun deleteTVShow(tvShowEntity: TvShowEntity, delete: () -> Unit) = ioThread {
        appDatabase.tvShowDao().deleteTvshow(tvShowEntity)
        delete()
    }

}