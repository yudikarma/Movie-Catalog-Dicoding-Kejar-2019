package com.yudikarma.moviecatalogsubmision2.data.network.client

//import com.yudikarma.moviecatalogsubmision2.data.network.prefrence.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/*class ApiHeaderInterceptor @Inject
constructor(internal var preferenceHelper: PreferenceHelper) :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var builder = request.newBuilder()
        builder.addHeader("Authorization","Bearer "+preferenceHelper.get)
    }

}*/
