package com.yudikarma.moviecatalogsubmision2.feature.ui.match.favoriteMatch

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.Database.Favorite
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import javax.inject.Inject

class FavoriteMatchViewModel @Inject constructor(): BaseViewModel() {
    val data = MutableLiveData<List<Favorite>>()

    fun getFavoriteMatch(){
        data.value = repository.getListFavoriteMatch()
    }
}