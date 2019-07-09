package com.yudikarma.moviecatalogsubmision2.data.network

enum class Status {
    NOTCONNECTED,
    RUNNING,
    SUCCESS,
    FAILED,
    EOF
}
 data class NetworkState constructor(
     val status:Status,
     val msg: String? = null) {
     companion object {
         val LOADED = NetworkState(Status.SUCCESS)
         val LOADING = NetworkState(Status.RUNNING)
         fun failure(msg: String?) = NetworkState(Status.NOTCONNECTED, msg)
         fun error(msg: String?) = NetworkState(Status.FAILED, msg)
     }
}