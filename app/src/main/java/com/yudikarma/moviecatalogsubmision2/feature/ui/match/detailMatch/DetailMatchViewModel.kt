package com.yudikarma.moviecatalogsubmision2.feature.ui.match.detailMatch

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.network.NetworkState
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.data.network.model.TeamDetailModel
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import com.yudikarma.moviecatalogsubmision2.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class DetailMatchViewModel@Inject constructor() : BaseViewModel(){
    val data = MutableLiveData<LastMatchModel>()

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

    fun getDetailMatch(eventId:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                val request = repository.getDetailMatch(eventId)
                val response = request.await()
                if (response.isSuccessful){
                    networkState.postValue(NetworkState.LOADED)
                    data.value = response.body()
                }else{
                    networkState.postValue(NetworkState.error(response.message()))
                }
            }catch (e : Exception){
                if (e is IOException){
                    networkState.postValue(NetworkState.failure(AppConstants.CONNECTION_FAILED))
                }else{
                    networkState.postValue(NetworkState.error(e.localizedMessage))
                }
            }
        }
    }

    val dataTeamHome = MutableLiveData<TeamDetailModel>()
    val dataTeamAway = MutableLiveData<TeamDetailModel>()


    fun getTeamInfoHome(id:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                val request = repository.getTeamInfo(id)
                val response = request.await()
                if (response.isSuccessful){
                    networkState.postValue(NetworkState.LOADED)
                    dataTeamHome.value = response.body()
                }else{
                    networkState.postValue(NetworkState.error(response.message()))
                }
            }catch (e : Exception){
                if (e is IOException){
                    networkState.postValue(NetworkState.failure(AppConstants.CONNECTION_FAILED))
                }else{
                    networkState.postValue(NetworkState.error(e.localizedMessage))
                }
            }
        }
    }

    fun getTeamInfoAway(id:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                val request = repository.getTeamInfo(id)
                val response = request.await()
                if (response.isSuccessful){
                    networkState.postValue(NetworkState.LOADED)
                    dataTeamAway.value = response.body()
                }else{
                    networkState.postValue(NetworkState.error(response.message()))
                }
            }catch (e : Exception){
                if (e is IOException){
                    networkState.postValue(NetworkState.failure(AppConstants.CONNECTION_FAILED))
                }else{
                    networkState.postValue(NetworkState.error(e.localizedMessage))
                }
            }
        }
    }
}