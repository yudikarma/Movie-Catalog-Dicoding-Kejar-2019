package com.yudikarma.moviecatalogsubmision2.ui.detail_movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem

class DetailMovieViewModel():ViewModel(){
    val data = MutableLiveData<ResultsItem>()
}