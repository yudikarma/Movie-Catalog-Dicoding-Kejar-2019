package com.yudikarma.moviecatalogsubmision2.feature.broadcastReceiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.yudikarma.moviecatalogsubmision2.feature.ui.MainActivity
import com.yudikarma.moviecatalogsubmision2.utils.Utils
import java.util.*

class ReminderDailyReceiver : BroadcastReceiver() {

    companion object{
        var ID = 1


    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("Daily alarm is called","")
        context?.let {
            Utils.sendNotificationDailyReminder(it)
        }
    }

    fun setAlarm(context: Context) {
        cancelAlarm(context)
        Log.d("Daily alarm is Set","   alarm is sett")

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 7)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            assert(alarmManager != null)
            alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                getPendingIntent(context)
            )
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            assert(alarmManager != null)
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis, getPendingIntent(context)
            )
        }
    }

    fun cancelAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(getPendingIntent(context))
    }
    private fun getPendingIntent(context: Context): PendingIntent {
        val intent = Intent(context, ReminderDailyReceiver::class.java)
        return PendingIntent.getBroadcast(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }




}