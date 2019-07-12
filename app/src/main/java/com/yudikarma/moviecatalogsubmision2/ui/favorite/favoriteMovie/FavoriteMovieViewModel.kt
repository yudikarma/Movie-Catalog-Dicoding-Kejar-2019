package com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseViewModel
import javax.inject.Inject

class FavoriteMovieViewModel @Inject constructor(): BaseViewModel() {

    var data: MediatorLiveData<List<MovieEntity>> = MediatorLiveData()


    fun getAllFavoriteMovie() = data.addSource(repository.getALlFavoriteMovie()){
        data.value = it
    }

    fun deleteMovie(movieEntity: MovieEntity) {
        repository.deleteMovie(movieEntity){

        }
    }
}