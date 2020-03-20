package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface ApiHelper {

    fun getListMovies(api_key:String?,language:String?):Deferred<Response<Movie>>
    fun getListTvShow(api_key:String?,language:String?):Deferred<Response<TvShow>>
    fun searchMovie(api_key: String?,language: String?,query:String?):Deferred<Response<Movie>>
    fun searchTVshow(api_key: String?,language: String?,query:String?):Deferred<Response<TvShow>>
    fun listMovieUpcoming(api_key: String?,language: String?):Deferred<Response<MovieUpcoming>>

    //liga
    fun getDetailLifa(id: String):Deferred<Response<LigaDetailModel>>
    fun getLastMatch(id: String):Deferred<Response<LastMatchModel>>
    fun getNextMatch(id: String):Deferred<Response<LastMatchModel>>
    fun getMatchByName(keyword:String):Deferred<Response<ListMatchByName>>
    fun getDetailMatch(id:String):Deferred<Response<LastMatchModel>>
    fun getDetailTeamInfo(id:String):Deferred<Response<TeamDetailModel>>
    fun getAllTeamInLiga(ligaName:String):Deferred<Response<TeamModel>>
    fun getTeamByName(teamName:String):Deferred<Response<TeamModel>>

}