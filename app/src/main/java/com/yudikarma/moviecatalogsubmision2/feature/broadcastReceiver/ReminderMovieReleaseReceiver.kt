package com.yudikarma.moviecatalogsubmision2.feature.broadcastReceiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemMovieUpcoming
import com.yudikarma.moviecatalogsubmision2.feature.ui.MainActivity
import com.yudikarma.moviecatalogsubmision2.utils.Utils
import java.util.*

class ReminderMovieReleaseReceiver : BroadcastReceiver() {

    companion object{
        var ID = 1
        var notifId = 1;


    }
    fun setAlarm(context: Context,data :List<ResultsItemMovieUpcoming>) {
        Log.d("release movie is Set","sdsdsdsds")
        var delay = 0

        for (filmModel in data) {
            cancelAlarm(context)
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(context, ReminderMovieReleaseReceiver::class.java)
            intent.putExtra("title", filmModel.title)
            intent.putExtra("id", filmModel.id)
            intent.putExtra("poster_path", filmModel.poster_path)
            intent.putExtra("release_date", filmModel.release_date)
            intent.putExtra("vote_average", filmModel.vote_average)
            intent.putExtra("overview", filmModel.overview)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                100, intent, PendingIntent.FLAG_UPDATE_CURRENT
            )

            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 7)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                assert(alarmManager != null)
                alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis + delay,
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent
                )
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                assert(alarmManager != null)
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis + delay, pendingIntent
                )
            }
            notifId += 1
            delay += 3000
        }
    }

    fun cancelAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(getPendingIntent(context))
    }
    private fun getPendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, ReminderMovieReleaseReceiver::class.java)
        return PendingIntent.getBroadcast(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("release movie is Caled","")
        context?.let {
            var judul = intent?.getStringExtra("title")
            var id:Int? =intent?.getStringExtra("id")?.toInt()
            var poster = intent?.getStringExtra("poster_path")
            var rilis = intent?.getStringExtra("release_date")
            var rating = intent?.getStringExtra("vote_average")
            var deskripsi =  intent?.getStringExtra("overview")
            //val myMovies = ResultsItemMovieUpcoming(title = judul!!,id = id!!,poster_path = poster!!,release_date = rilis!!,vote_average = rating!!.toDouble(),overview = deskripsi!!)
            //val desc = "Release Movie Today!"
            Utils.sendNotificationUpcomingReminder(context,poster,judul,deskripsi)
        }
    }





}