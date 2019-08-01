package com.yudikarma.moviecatalogsubmision2.feature.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import android.widget.Toast
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.mystackwidget.StackWidgetService
import dagger.android.AndroidInjection
import javax.inject.Inject


/**
 * Implementation of App Widget functionality.
 */
class FavoriteMovieWIdget : AppWidgetProvider() {


    /*test inject widget*/
    @Inject
    internal lateinit var repository: Repository


    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        AndroidInjection.inject(this, context)
        super.onReceive(context, intent)

        if (intent?.getAction() != null) {
            if (intent?.getAction().equals(TOAST_ACTION)) {
                val viewIndex = intent.getIntExtra(EXTRA_ITEM, 0)
                Toast.makeText(context, "Touched view $viewIndex", Toast.LENGTH_SHORT).show()
            }
        }
    }




    companion object {
        val TOAST_ACTION = "com.dicoding.picodiploma.TOAST_ACTION"
        val EXTRA_ITEM = "com.dicoding.picodiploma.EXTRA_ITEM"
        //val EXTRA_DATA = "com.dicoding.picodiploma.EXTRA_DATA"
    }

    fun updateAppWidget(
        context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int
    ) {
        val intent = Intent(context, StackWidgetService::class.java)
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        //intent.putExtra("EXTRA_DATA",mWidgetItems)
        intent.data = Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME))


        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.favorite_movie_widget)
        views.setRemoteAdapter(R.id.stack_view, intent)
        views.setEmptyView(R.id.stack_view, R.id.empty_view)


        val toastIntent = Intent(context, FavoriteMovieWIdget::class.java)
        toastIntent.action = FavoriteMovieWIdget.TOAST_ACTION
        toastIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        intent.data = Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME))


        val toastPendingIntent =
            PendingIntent.getBroadcast(context, appWidgetId, toastIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        views.setPendingIntentTemplate(R.id.stack_view, toastPendingIntent)
        appWidgetManager.updateAppWidget(appWidgetId, views)


    }

}

