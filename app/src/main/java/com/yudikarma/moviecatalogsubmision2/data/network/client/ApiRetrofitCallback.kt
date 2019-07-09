package com.yudikarma.moviecatalogsubmision2.data.network.client

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRetrofitCallback<T>(initMethod:ApiRetrofitCallback<T>.() -> Unit):Callback<T> {
    private var _failureCallback: (call:Call<T>?,throwable:Throwable?) -> Unit ={ _, _ -> }
    private var _successCallback: (call:Call<T>?,response:Response<T>?) -> Unit ={ _, _ -> }

    override fun onFailure(call: Call<T>, t: Throwable) {
        _failureCallback(call, t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        _successCallback(call, response)

    }

    fun onFailureCallback(function : (call:Call<T>?,throwable:Throwable?) -> Unit){
        _failureCallback = function
    }
    fun onSuccessCallback(function : (call:Call<T>?,response:Response<T>?) -> Unit){
        _successCallback =function
    }
    init {
        initMethod()
    }

}