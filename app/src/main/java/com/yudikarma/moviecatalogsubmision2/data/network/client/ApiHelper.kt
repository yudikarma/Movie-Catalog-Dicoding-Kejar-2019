package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface ApiHelper {

    fun getListMovies(api_key:String?,language:String?):Deferred<Response<Movie>>
    fun getListTvShow(api_key:String?,language:String?):Deferred<Response<TvShow>>

}