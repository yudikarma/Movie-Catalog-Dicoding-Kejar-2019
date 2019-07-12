package com.yudikarma.moviecatalogsubmision2.data.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(val page: Int = 0,
                  val totalPages: Int = 0,
                  val results: List<ResultsItemTvShow>?,
                  val totalResults: Int = 0):Parcelable


@Parcelize
data class ResultsItemTvShow(val first_air_date: String = "",
                       val overview: String = "",
                       val original_language: String = "",
                       val genre_ids: List<Int>?,
                       val poster_path: String = "",
                       val backdrop_path: String = "",
                       val original_name: String = "",
                       val popularity: Double = 0.0,
                       val vote_average: Double = 0.0,
                       val name: String = "",
                       val id: Int = 0,
                       val vote_count: Int = 0):Parcelable


