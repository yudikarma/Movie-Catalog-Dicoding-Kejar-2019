package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteTvShow

import androidx.lifecycle.MediatorLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
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