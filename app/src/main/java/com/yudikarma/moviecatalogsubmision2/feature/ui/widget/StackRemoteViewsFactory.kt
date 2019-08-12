package com.yudikarma.mystackwidget

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.feature.ui.widget.FavoriteMovieWIdget
import java.lang.Exception
import android.appwidget.AppWidgetManager
import android.graphics.Bitmap
import android.os.Binder
import android.os.Handler
import android.os.Looper
import com.yudikarma.moviecatalogsubmision2.data.Repository
import dagger.android.AndroidInjection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class StackRemoteViewsFactory: RemoteViewsService.RemoteViewsFactory {
    private var mContext: Context? = null
    private var mWidgetItems:ArrayList<MovieEntity> = arrayListOf()
    private var repository: Repository
    private var idWidget:Int? = null


    constructor(context: Context,intent: Intent,repository: Repository){
        mContext = context
        this.repository = repository
        this.idWidget = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID)

        Log.d("widget path ",""+this.idWidget)

    }




    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getViewAt(position: Int): RemoteViews {


        val rv = RemoteViews(mContext?.getPackageName(), R.layout.widget_item)
        var bitmap :Bitmap? =null/* BitmapFactory.decodeResource(mContext?.getResources(), R.drawable.poster_aquaman)*/
        try {
                val urlImage = "https://image.tmdb.org/t/p/w500"
                bitmap = Glide.with(mContext!!)
                    .asBitmap()
                    .load(urlImage+mWidgetItems[position].poster_path)
                    .submit(512,512)
                    .get()


        }catch (e : Exception){


        }
        rv.setImageViewBitmap(R.id.imageView,bitmap)

        //rv.setImageViewBitmap(R.id.imageView, mWidgetItems[position])
        val extras = Bundle()
        extras.putInt(FavoriteMovieWIdget.EXTRA_ITEM, position)
        val fillInIntent = Intent()
        fillInIntent.putExtras(extras)
        rv.setOnClickFillInIntent(R.id.imageView, fillInIntent)
        return rv
    }

    override fun getCount(): Int {
        return mWidgetItems.size
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun onDestroy() {}

    override fun onCreate() {
    }

    override fun onDataSetChanged() {

        GlobalScope.launch(Dispatchers.Main) {
            repository.suspendGetALlFavoriteMovie {
                Handler(Looper.getMainLooper()).post(Runnable {
                    // things to do on the main thread
                    val idt:Long = Binder.clearCallingIdentity()
                    mWidgetItems.addAll(it)
                    Binder.restoreCallingIdentity(idt)

                    Log.d("widget items",""+mWidgetItems)
                })
            }
        }

    }
}