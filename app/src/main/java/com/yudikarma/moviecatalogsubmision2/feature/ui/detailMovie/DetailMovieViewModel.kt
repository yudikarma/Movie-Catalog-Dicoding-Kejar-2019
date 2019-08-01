package com.yudikarma.moviecatalogsubmision2.feature.ui.detailMovie

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import javax.inject.Inject

class DetailMovieViewModel@Inject constructor() : BaseViewModel(){
    val data = MutableLiveData<ResultsItem>()

    fun insertVaforiteMovie(movieEntity: MovieEntity) {
        repository.insertFavoriteMovie(movieEntity){
        }
    }

    fun deleteMovie(movieEntity: MovieEntity) {
        repository.deleteMovie(movieEntity){

        }
    }

    suspend fun getFavoriteCOunt(id:Long)  = repository.getFavoriteCount(id){ size ->

    }
}