package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiNetwork {

    //getListMovies
    @FormUrlEncoded
    @POST("movie")
    fun getListMovies(@Field("api_key")api_key:String?,
                      @Field("language")language:String?):Deferred<Response<Movie>>

    //getListTVShow
    @FormUrlEncoded
    @POST("tv")
    fun getListTVShow(@Field("api_key")api_key:String?,
                      @Field("language")language:String?):Deferred<Response<TvShow>>


}