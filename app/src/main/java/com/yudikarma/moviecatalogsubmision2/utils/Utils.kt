package com.yudikarma.moviecatalogsubmision2.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import androidx.core.app.NotificationCompat
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemMovieUpcoming
import com.yudikarma.moviecatalogsubmision2.feature.ui.MainActivity
import java.lang.Exception


object Utils {
    val NOTIFICATION_ID = 22
    private val CHANNEL_ID = "notify"
    private val CHANNEL_NAME = "workmanager-reminder"

    fun sendNotificationDailyReminder(context: Context){
        val intent = Intent(context,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 1,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT)
            notificationChannel.enableVibration(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = R.color.colorPrimary
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

            notificationManager.createNotificationChannel(notificationChannel)
        }
        val notificationbuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Movie Catalog")
            .setContentText("Welcome movie catalog, checkout news Movie and TV Show")
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_favorite_white_24dp)

        notificationManager.notify(1,notificationbuilder.build())
    }


    fun sendNotificationUpcomingReminder(context: Context,poster_path:String?,title:String?,overview:String?){
           val intent = Intent(context,MainActivity::class.java)
           val pendingIntent = PendingIntent.getActivity(context, 1,intent,PendingIntent.FLAG_UPDATE_CURRENT)
           val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

           /*var bitmap : Bitmap? =null*//* BitmapFactory.decodeResource(mContext?.getResources(), R.drawable.poster_aquaman)*//*
           try {
               val urlImage = "https://image.tmdb.org/t/p/w500"
               bitmap = Glide.with(context)
                   .asBitmap()
                   .load(""+urlImage+poster_path)
                   .submit()
                   .get()
           }catch (e : Exception){


           }*/
           if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
               val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT)
               notificationChannel.enableVibration(true)
               notificationChannel.enableLights(true)
               notificationChannel.lightColor = R.color.colorPrimary
               notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

               notificationManager.createNotificationChannel(notificationChannel)
           }
           val notificationbuilder = NotificationCompat.Builder(context, CHANNEL_ID)
               .setContentTitle("Rilis Today : ${title}")
               .setContentText(""+overview)
               .setAutoCancel(true)
               .setContentIntent(pendingIntent)
               .setSmallIcon(R.drawable.ic_movie_white_24dp)
               //.setLargeIcon(bitmap)
               //.setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))

           notificationManager.notify(1,notificationbuilder.build())


    }

    fun serializeToJson(arraylist: ArrayList<ResultsItemMovieUpcoming>): String {
        val gson = Gson()
        return gson.toJson(arraylist)
    }

    fun deseriablizeFromJson(jsonString:String?):ArrayList<ResultsItemMovieUpcoming>{

        val gson : Gson = Gson()
        val baseType = object : TypeToken<ArrayList<ResultsItemMovieUpcoming>>() {

        }.type
        return gson.fromJson(jsonString,baseType)
    }
}