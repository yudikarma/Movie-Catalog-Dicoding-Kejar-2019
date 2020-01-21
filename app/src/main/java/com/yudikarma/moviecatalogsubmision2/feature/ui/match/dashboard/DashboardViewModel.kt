package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.network.NetworkState
import com.yudikarma.moviecatalogsubmision2.data.network.model.LigaDetailModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ListMatchByName
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import com.yudikarma.moviecatalogsubmision2.utils.AppConstants
import com.yudikarma.moviecatalogsubmision2.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class DashboardViewModel @Inject constructor():BaseViewModel() {

    val data = MutableLiveData<LigaDetailModel>()

    fun getDetailLiga(id:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                EspressoIdlingResource.increment()
                val request = repository.getDetailLifa(id)
                val response = request.await()
                if (response.isSuccessful){
                    networkState.postValue(NetworkState.LOADED)
                    data.value = response.body()
                    EspressoIdlingResource.decrement()
                }else{
                    EspressoIdlingResource.decrement()
                    networkState.postValue(NetworkState.error(response.message()))
                }
            }catch (e : Exception){
                if (e is IOException){
                    networkState.postValue(NetworkState.failure(AppConstants.CONNECTION_FAILED))
                }else{
                    networkState.postValue(NetworkState.error(e.localizedMessage))
                }
                EspressoIdlingResource.decrement()
            }
        }
    }

    val dataMatchByName = MutableLiveData<ListMatchByName>()

    fun getMatchByName(keyword:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                EspressoIdlingResource.increment()
                val request = repository.getMatchByName(keyword)
                val response = request.await()
                if (response.isSuccessful){
                    networkState.postValue(NetworkState.LOADED)
                    dataMatchByName.value = response.body()
                    EspressoIdlingResource.decrement()
                }else{
                    EspressoIdlingResource.decrement()
                    networkState.postValue(NetworkState.error(response.message()))
                }
            }catch (e : java.lang.Exception){
                if (e is IOException){
                    networkState.postValue(NetworkState.failure(AppConstants.CONNECTION_FAILED))
                }else{
                    networkState.postValue(NetworkState.error(e.localizedMessage))
                }
                EspressoIdlingResource.decrement()
            }
        }
    }
}