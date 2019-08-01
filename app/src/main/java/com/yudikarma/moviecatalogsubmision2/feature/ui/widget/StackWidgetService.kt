package com.yudikarma.mystackwidget

import android.content.Intent
import android.util.Log
import android.widget.RemoteViewsService
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import dagger.android.AndroidInjection
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class StackWidgetService() : RemoteViewsService() {

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    @Inject
    internal lateinit var repository: Repository

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory? {

        return StackRemoteViewsFactory(this.getApplicationContext(), intent,repository)
    }
}