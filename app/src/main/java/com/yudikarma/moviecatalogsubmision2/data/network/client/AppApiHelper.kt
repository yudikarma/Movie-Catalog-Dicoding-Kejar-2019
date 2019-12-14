package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.yudikarma.moviecatalogsubmision2.data.network.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject

class AppApiHelper @Inject constructor(
            private val apiNetwork: ApiNetwork) :ApiHelper{
    override fun getDetailTeamInfo(id: String): Deferred<Response<TeamDetailModel>> = apiNetwork.getTeamInfoDetail(id)

    override fun getDetailLifa(id: String): Deferred<Response<LigaDetailModel>> = apiNetwork.getDetailLiga(id)

    override fun getLastMatch(id: String): Deferred<Response<LastMatchModel>> = apiNetwork.getLastMatch(id)

    override fun getNextMatch(id: String): Deferred<Response<LastMatchModel>> = apiNetwork.getNextMatch(id)

    override fun getMatchByName(keyword: String): Deferred<Response<ListMatchByName>> = apiNetwork.getEventByName(keyword)

    override fun getDetailMatch(id: String): Deferred<Response<LastMatchModel>> = apiNetwork.getDetailMatch(id)

    override fun listMovieUpcoming(api_key: String?, language: String?): Deferred<Response<MovieUpcoming>> = apiNetwork.listMovieUpcoming(api_key,language)

    override fun searchMovie(api_key: String?, language: String?, query: String?): Deferred<Response<Movie>> = apiNetwork.searchMovie(api_key,language,query)

    override fun searchTVshow(api_key: String?, language: String?, query: String?): Deferred<Response<TvShow>> = apiNetwork.searchTvShow(api_key,language,query)

    override fun getListMovies(api_key: String?, language: String?): Deferred<Response<Movie>> = apiNetwork.getListMovies(api_key,language)

    override fun getListTvShow(api_key: String?, language: String?): Deferred<Response<TvShow>> = apiNetwork.getListTVShow(api_key,language)
}