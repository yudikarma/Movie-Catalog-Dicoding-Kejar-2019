package com.yudikarma.moviecatalogsubmision2.feature.ui.match

import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.network.NetworkState
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ListMatchByName
import com.yudikarma.moviecatalogsubmision2.data.network.model.MovieUpcoming
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseViewModel
import com.yudikarma.moviecatalogsubmision2.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor():BaseViewModel() {
    val data = MutableLiveData<MovieUpcoming>()
}