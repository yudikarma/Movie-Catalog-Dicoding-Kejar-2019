package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject

class AppApiHelper @Inject constructor(
            private val apiNetwork: ApiNetwork) :ApiHelper{
    override fun getListMovies(api_key: String?, language: String?): Deferred<Response<Movie>> = apiNetwork.getListMovies(api_key,language)

    override fun getListTvShow(api_key: String?, language: String?): Deferred<Response<TvShow>> = apiNetwork.getListTVShow(api_key,language)
}