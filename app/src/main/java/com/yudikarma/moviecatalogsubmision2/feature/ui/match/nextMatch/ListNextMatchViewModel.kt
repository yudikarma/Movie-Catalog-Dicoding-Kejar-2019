package com.yudikarma.moviecatalogsubmision2.feature.ui.match.nextMatch

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.network.NetworkState
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.TvShow
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import com.yudikarma.moviecatalogsubmision2.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class ListNextMatchViewModel @Inject constructor() : BaseViewModel() {
    val data = MutableLiveData<LastMatchModel>()

    fun getListNextMatch(id:String){
        networkState.postValue(NetworkState.LOADING)
        GlobalScope.launch(Dispatchers.Main){
            try {
                val request = repository.getNextMatch(id)
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


}