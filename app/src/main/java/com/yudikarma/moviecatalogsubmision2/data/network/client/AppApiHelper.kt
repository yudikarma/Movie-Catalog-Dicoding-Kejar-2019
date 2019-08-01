package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.MovieUpcoming
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject

class AppApiHelper @Inject constructor(
            private val apiNetwork: ApiNetwork) :ApiHelper{
    override fun listMovieUpcoming(api_key: String?, language: String?): Deferred<Response<MovieUpcoming>> = apiNetwork.listMovieUpcoming(api_key,language)

    override fun searchMovie(api_key: String?, language: String?, query: String?): Deferred<Response<Movie>> = apiNetwork.searchMovie(api_key,language,query)

    override fun searchTVshow(api_key: String?, language: String?, query: String?): Deferred<Response<TvShow>> = apiNetwork.searchTvShow(api_key,language,query)

    override fun getListMovies(api_key: String?, language: String?): Deferred<Response<Movie>> = apiNetwork.getListMovies(api_key,language)

    override fun getListTvShow(api_key: String?, language: String?): Deferred<Response<TvShow>> = apiNetwork.getListTVShow(api_key,language)
}