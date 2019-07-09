package com.yudikarma.moviecatalogsubmision2.ui.detail_tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow

 class DetailTvShowViewModel():ViewModel(){
     val data = MutableLiveData<ResultsItemTvShow>()

 }