package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.Database.Favorite
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import javax.inject.Inject

class TeamFavoriteViewModel @Inject constructor(): BaseViewModel() {
    val data = MutableLiveData<List<Favorite>>()

    fun getFavoriteMatch(){
        data.value = repository.getListFavoriteMatch()
    }
}