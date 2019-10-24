package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.Movie
import com.yudikarma.moviecatalogsubmision2.data.network.model.MovieUpcoming
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiNetwork {

    //getListMovies
    @GET("movie")
    fun getListMovies(@Query("api_key")api_key:String?,
                      @Query("language")language:String?):Deferred<Response<Movie>>

    //getListTVShow
    @GET("tv")
    fun getListTVShow(@Query("api_key")api_key:String?,
                      @Query("language")language:String?):Deferred<Response<TvShow>>

    //search movie
    @GET("https://api.themoviedb.org/3/search/movie")
    fun searchMovie(@Query("api_key")api_key:String?,
                    @Query("language")language:String?,
                    @Query("query")query:String?):Deferred<Response<Movie>>

    //search tvshow
    @POST("https://api.themoviedb.org/3/search/tv")
    fun searchTvShow(@Query("api_key")api_key:String?,
                     @Query("language")language:String?,
                     @Query("query")query:String?):Deferred<Response<TvShow>>

    //movie Upcoming
    @POST("https://api.themoviedb.org/3/movie/upcoming")
    fun listMovieUpcoming(
        @Query("api_key")api_key:String?,
        @Query("language")language:String?
    ):Deferred<Response<MovieUpcoming>>


}