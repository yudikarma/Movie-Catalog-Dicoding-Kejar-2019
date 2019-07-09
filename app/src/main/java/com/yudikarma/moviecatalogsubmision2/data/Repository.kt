package com.yudikarma.moviecatalogsubmision2.data

import android.content.Context
import com.yudikarma.moviecatalogsubmision2.BuildConfig
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper

class Repository(private val apiHelper: ApiHelper,
                 private val context: Context) {

     fun getListMovies() = apiHelper.getListMovies(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)

     fun getListTvShow() = apiHelper.getListTvShow(BuildConfig.API_KEY,BuildConfig.LANGUAGE_EN)
}