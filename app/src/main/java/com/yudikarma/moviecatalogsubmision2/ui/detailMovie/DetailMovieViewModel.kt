package com.yudikarma.moviecatalogsubmision2.ui.detailMovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseViewModel
import javax.inject.Inject

class DetailMovieViewModel@Inject constructor() : BaseViewModel(){
    val data = MutableLiveData<ResultsItem>()

    fun insertVaforiteMovie(movieEntity: MovieEntity) {
        repository.insertFavoriteMovie(movieEntity){
        }
    }
}