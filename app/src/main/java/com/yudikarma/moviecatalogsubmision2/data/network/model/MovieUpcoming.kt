package com.yudikarma.moviecatalogsubmision2.data.network.model

import java.io.Serializable

data class ResultsItemMovieUpcoming(val overview: String = "",
                                    val original_language: String = "",
                                    val original_title: String = "",
                                    val video: Boolean = false,
                                    val title: String = "",
                                    val genre_ids: List<Integer>? = null,
                                    val poster_path: String = "",
                                    val backdrop_path: String = "",
                                    val release_date: String = "",
                                    val vote_average: Double = 0.0,
                                    val popularity: Double = 0.0,
                                    val id: Int = 0,
                                    val adult: Boolean = false,
                                    val vote_count: Int = 0) :Serializable


data class Dates(val maximum: String = "",
                 val minimum: String = "")


data class MovieUpcoming(val dates: Dates,
                         val page: Int = 0,
                         val totalPages: Int = 0,
                         val results: List<ResultsItemMovieUpcoming>?,
                         val totalResults: Int = 0)


