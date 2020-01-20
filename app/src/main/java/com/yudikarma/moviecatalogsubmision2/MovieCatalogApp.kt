package com.yudikarma.moviecatalogsubmision2

import android.app.Activity
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import androidx.work.Configuration
import com.orhanobut.hawk.Hawk
import com.yudikarma.moviecatalogsubmision2.di.component.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject


open class MovieCatalogApp : MultiDexApplication(),HasContentProviderInjector,HasActivityInjector, HasBroadcastReceiverInjector,HasServiceInjector,
    Configuration.Provider {


    @Inject
    internal lateinit var dispatchingServiceInjector:DispatchingAndroidInjector<Service>
    override fun serviceInjector(): AndroidInjector<Service> = dispatchingServiceInjector

    @Inject
    internal lateinit var dispatchingAndroidInjector :DispatchingAndroidInjector<Activity>
    override fun activityInjector() = dispatchingAndroidInjector


    @Inject
    internal lateinit var broadcastReceiverInjector :DispatchingAndroidInjector<BroadcastReceiver>
    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = broadcastReceiverInjector

    @Inject
    internal lateinit var contentProviderInjector: DispatchingAndroidInjector<ContentProvider>
    override fun contentProviderInjector(): AndroidInjector<ContentProvider> = contentProviderInjector

    companion object {
        private var instance :MovieCatalogApp? = null

        fun getInstance():MovieCatalogApp{

            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Hawk.init(this).build()


    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        //init Dagger
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }




    /**
     * The [Application]. Responsible for initializing [WorkManager] in [Log.VERBOSE] mode.
     */
    override fun getWorkManagerConfiguration(): Configuration  = Configuration.Builder().setMinimumLoggingLevel(Log.VERBOSE).build()

}
