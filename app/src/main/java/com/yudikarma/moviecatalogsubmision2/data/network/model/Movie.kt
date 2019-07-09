package com.yudikarma.moviecatalogsubmision2.data.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val page: Int = 0,
                 val totalPages: Int = 0,
                 val results: List<ResultsItem>?,
                 val totalResults: Int = 0) :Parcelable


@Parcelize
data class ResultsItem(val overview: String = "",
                       val original_language: String = "",
                       val original_title: String = "",
                       val video: Boolean = false,
                       val title: String = "",
                       val genre_ids: List<Integer>?,
                       val poster_path: String = "",
                       val backdrop_path: String = "",
                       val release_date: String = "",
                       val vote_average: Double = 0.0,
                       val popularity: Double = 0.0,
                       val id: Int = 0,
                       val adult: Boolean = false,
                       val vote_count: Int = 0):Parcelable


