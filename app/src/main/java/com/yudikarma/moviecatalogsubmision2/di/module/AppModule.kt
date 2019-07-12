package com.yudikarma.moviecatalogsubmision2.di.module

import android.app.Application
import android.content.ContentProviderClient
import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.yudikarma.moviecatalogsubmision2.BuildConfig
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHeader
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiNetwork
import com.yudikarma.moviecatalogsubmision2.data.network.client.AppApiHelper
import com.yudikarma.moviecatalogsubmision2.di.ApiKeyInfo
import com.yudikarma.moviecatalogsubmision2.utils.AppConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application:Application):Context = application

    @Provides
    @Singleton
    internal fun provideApiKey():String = BuildConfig.API_KEY

    @Provides
    @Named(AppConstants.BASE_URL)
    internal fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor() :HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideApiHeaderKey(@ApiKeyInfo apiKey: String):
            ApiHeader.ApiHeaderKey = ApiHeader.ApiHeaderKey(api_key = apiKey)





    @Provides
    @Singleton
    internal fun provideGsonConverterFactory(): Converter.Factory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    internal fun funprovideCallAdapterFactory(): CallAdapter.Factory{
        return CoroutineCallAdapterFactory()
    }

    @Provides
    @Singleton
    internal fun provideHttpClient(
                                   httpInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .build()
    }

    @Provides
    @Singleton
    internal fun funprovideRetrofit(@Named(AppConstants.BASE_URL) baseUrl:String,converterFactory: Converter.Factory,
                                    callAdapterFactory: CallAdapter.Factory,client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideApiNetwork(retrofit: Retrofit):ApiNetwork{
        return retrofit.create(ApiNetwork::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRepository(apiHelper: ApiHelper,appDatabase: AppDatabase,context: Context): Repository = Repository(apiHelper,appDatabase,context)

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

}