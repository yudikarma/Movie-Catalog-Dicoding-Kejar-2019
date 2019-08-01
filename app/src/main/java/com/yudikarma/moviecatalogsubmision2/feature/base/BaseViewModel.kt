package com.yudikarma.moviecatalogsubmision2.feature.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.network.NetworkState
import javax.inject.Inject

open class BaseViewModel @Inject constructor():ViewModel() {
    @Inject
    lateinit var repository: Repository

    val networkState = MediatorLiveData<NetworkState>()
}