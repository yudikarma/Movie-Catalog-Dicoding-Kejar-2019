package com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteTvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseViewModel
import javax.inject.Inject

class FavoriteTvShowViewModel@Inject constructor(): BaseViewModel() {

    var data: MediatorLiveData<List<TvShowEntity>> = MediatorLiveData()


    fun getAllFavoriteTVshow() = data.addSource(repository.getALlFavoriteTvShow()){
        data.value = it
    }

    fun deleteTVshow(tvShowEntity: TvShowEntity) {
        repository.deleteTVShow(tvShowEntity){

        }
    }
}