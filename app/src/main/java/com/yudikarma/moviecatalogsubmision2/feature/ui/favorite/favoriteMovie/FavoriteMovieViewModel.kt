package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie

import androidx.lifecycle.MediatorLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
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