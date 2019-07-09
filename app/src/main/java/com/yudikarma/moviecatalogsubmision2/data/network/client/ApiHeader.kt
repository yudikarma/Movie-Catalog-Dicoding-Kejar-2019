package com.yudikarma.moviecatalogsubmision2.data.network.client

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ApiHeader @Inject constructor(internal val apiHeaderKey: ApiHeaderKey) {

    data class ApiHeaderKey @Inject constructor(@Expose @SerializedName("api_key") val api_key : String)
}
