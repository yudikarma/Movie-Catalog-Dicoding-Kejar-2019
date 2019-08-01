package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.MovieUpcoming
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

    //search movie
    @FormUrlEncoded
    @POST("https://api.themoviedb.org/3/search/movie")
    fun searchMovie(@Field("api_key")api_key:String?,
                    @Field("language")language:String?,
                    @Field("query")query:String?):Deferred<Response<Movie>>

    //search tvshow
    @FormUrlEncoded
    @POST("https://api.themoviedb.org/3/search/tv")
    fun searchTvShow(@Field("api_key")api_key:String?,
                    @Field("language")language:String?,
                    @Field("query")query:String?):Deferred<Response<TvShow>>

    //movie Upcoming
    @FormUrlEncoded
    @POST("https://api.themoviedb.org/3/movie/upcoming")
    fun listMovieUpcoming(
        @Field("api_key")api_key:String?,
        @Field("language")language:String?
    ):Deferred<Response<MovieUpcoming>>


}