package com.yudikarma.moviecatalogsubmision2.feature.ui.detailTvshow

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import javax.inject.Inject

class DetailTvShowViewModel @Inject constructor() : BaseViewModel(){
     val data = MutableLiveData<ResultsItemTvShow>()

     fun insertVaforiteTvShow(tvShowEntity: TvShowEntity) {
         repository.insertFavoriteTvShow(tvShowEntity){

         }
     }

    fun deleteTVshow(tvShowEntity: TvShowEntity) {
        repository.deleteTVShow(tvShowEntity){

        }
    }

    suspend fun getFavoriteCOunt(id:Long)  = repository.getFavoriteCountTVshow(id){ size ->

    }

 }