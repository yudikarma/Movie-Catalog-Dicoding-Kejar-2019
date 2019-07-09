package com.yudikarma.moviecatalogsubmision2

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.yudikarma.moviecatalogsubmision2.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class MovieCatalogApp : MultiDexApplication(),HasActivityInjector{

    @Inject
    internal lateinit var dispatchingAndroidInjector :DispatchingAndroidInjector<Activity>
    override fun activityInjector() = dispatchingAndroidInjector

    companion object {
        private var instance :MovieCatalogApp? = null

        fun getInstance():MovieCatalogApp{

            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //init Dagger
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }
}
