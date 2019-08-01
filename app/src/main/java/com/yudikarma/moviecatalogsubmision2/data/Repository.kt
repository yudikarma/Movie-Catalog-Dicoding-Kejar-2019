package com.yudikarma.moviecatalogsubmision2.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.yudikarma.moviecatalogsubmision2.BuildConfig
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import com.yudikarma.moviecatalogsubmision2.utils.ioThread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Repository(private val apiHelper: ApiHelper,
                 private val appDatabase: AppDatabase,
                 private val appPreferenceHelper: AppPreferenceHelper,
                 private val context: Context) {

    fun getListMovies() = apiHelper.getListMovies(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

     fun getListTvShow() = apiHelper.getListTvShow(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

    fun searchMovie(query:String?) = apiHelper.searchMovie(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN,query)

    fun searchTVShow(query: String?) = apiHelper.searchTVshow(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN,query)

    fun insertFavoriteMovie(movieEntity: MovieEntity, inserted:() -> Unit) = ioThread {
        appDatabase.movieDao().insertMovie(movieEntity)
        inserted()
    }

    fun getALlFavoriteMovie():LiveData<List<MovieEntity>> = appDatabase.movieDao().getAllMovie()


    suspend fun getFavoriteCount(id:Long, getfavorite: (size: Int) -> Unit): Int = suspendCoroutine{ continuation ->
        ioThread {
            val value = appDatabase.movieDao().getCountFavorite(id)
            getfavorite(value)
            continuation.resume(value)
        }
    }
    suspend fun suspendGetALlFavoriteMovie(getfavorite: (data: List<MovieEntity>) -> Unit):List<MovieEntity> =suspendCoroutine { continuation ->
        ioThread {
            val value = appDatabase.movieDao().getAllMoviesuspend()
            getfavorite(value)
            continuation.resume(value)
        }
    }

    suspend fun getFavoriteCountTVshow(id:Long, getfavorite: (size: Int) -> Unit): Int = suspendCoroutine{ continuation ->
        ioThread {
            val value = appDatabase.tvShowDao().getCountFavorite(id)
            getfavorite(value)
            continuation.resume(value)
        }
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


    fun deleteTVShow(tvShowEntity: TvShowEntity, delete: () -> Unit) = ioThread {
        appDatabase.tvShowDao().deleteTvshow(tvShowEntity)
        delete()
    }

    fun setBoolean(key:String,value: Boolean?) = appPreferenceHelper.setBoolean(key,value)

    fun getBoolean(key: String):Boolean = appPreferenceHelper.getBoolean(key)

    fun listMovieUpcoming() = apiHelper.listMovieUpcoming(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

    fun getInstanceAppDatabase() = appDatabase.getInstance(context)
}