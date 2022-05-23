package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.MovieUpcoming
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiNetwork {

    //getListMovies
    @GET("movie/popular")
    fun getListMovies(@Query("api_key")api_key:String?,
                      @Query("language")language:String?):Deferred<Response<Movie>>

    //getListTVShow
    @GET("tv/popular")
    fun getListTVShow(@Query("api_key")api_key:String?,
                      @Query("language")language:String?):Deferred<Response<TvShow>>

    //search movie
    @GET("search/movie")
    fun searchMovie(@Query("api_key")api_key:String?,
                    @Query("language")language:String?,
                    @Query("query")query:String?):Deferred<Response<Movie>>

    //search tvshow
    @GET("search/tv")
    fun searchTvShow(@Query("api_key")api_key:String?,
                    @Query("language")language:String?,
                    @Query("query")query:String?):Deferred<Response<TvShow>>

    //movie Upcoming
    @GET("movie/upcoming")
    fun listMovieUpcoming(
        @Query("api_key")api_key:String?,
        @Query("language")language:String?
    ):Deferred<Response<MovieUpcoming>>


}