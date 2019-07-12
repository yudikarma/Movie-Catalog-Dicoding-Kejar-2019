package com.yudikarma.moviecatalogsubmision2.ui.detailTvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseViewModel
import javax.inject.Inject

class DetailTvShowViewModel @Inject constructor() : BaseViewModel(){
     val data = MutableLiveData<ResultsItemTvShow>()

     fun insertVaforiteTvShow(tvShowEntity: TvShowEntity) {
         repository.insertFavoriteTvShow(tvShowEntity){

         }
     }

 }