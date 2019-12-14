package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.*
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


    //get last 15 match
    @GET("api/v1/json/1/eventspastleague.php?")
    fun getLastMatch(
        @Query("id")id: String
    ):Deferred<Response<LastMatchModel>>

    //get next match
    @GET("api/v1/json/1/eventsnextleague.php?")
    fun getNextMatch(
        @Query("id")id: String
    ):Deferred<Response<LastMatchModel>>

    //get detail liga
    @GET("api/v1/json/1/lookupleague.php?")
    fun getDetailLiga(
        @Query("id")id: String
    ):Deferred<Response<LigaDetailModel>>

    //search event by name
    @GET("api/v1/json/1/searchevents.php?")
    fun getEventByName(
        @Query("e")keyword:String?
    ):Deferred<Response<ListMatchByName>>

    //get event detail
    @GET("api/v1/json/1/lookupevent.php?")
    fun getDetailMatch(
        @Query("id") id:String
    ):Deferred<Response<LastMatchModel>>

    //get team info
    @GET("api/v1/json/1/lookupteam.php?")
    fun getTeamInfoDetail(
        @Query("id") id:String
    ):Deferred<Response<TeamDetailModel>>


}