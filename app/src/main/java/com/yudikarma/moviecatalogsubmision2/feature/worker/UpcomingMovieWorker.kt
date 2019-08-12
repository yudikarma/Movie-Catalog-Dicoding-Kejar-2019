package com.yudikarma.moviecatalogsubmision2.feature.worker

import android.content.Context
import android.util.Log
import androidx.work.*
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemMovieUpcoming
import com.yudikarma.moviecatalogsubmision2.utils.Utils
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class UpcomingMovieWorker(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {
        val context = applicationContext
        try {
            Log.d("do work", "Work called")

            val mapString:String? = inputData.getString("map")
            val datas :ArrayList<ResultsItemMovieUpcoming> = Utils.deseriablizeFromJson(mapString)

            /*val currentDate = Calendar.getInstance()
            val dueDate = Calendar.getInstance()
            // Set Execution around 07:00:00 AM
            dueDate.set(Calendar.HOUR_OF_DAY, 15)
            dueDate.set(Calendar.MINUTE, 0)
            dueDate.set(Calendar.SECOND, 0)
            if (dueDate.before(currentDate)) {
                dueDate.add(Calendar.HOUR_OF_DAY, 24)
            }
            val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis*/

            val constraint = Constraints.Builder()
                .setRequiresCharging(false)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val onetimeRequest = OneTimeWorkRequest.Builder(UpcomingMovieWorker::class.java)
                .setConstraints(constraint)
               // .setInitialDelay(timeDiff, TimeUnit.MILLISECONDS)
                .build()

            WorkManager.getInstance(applicationContext)
                .enqueue(onetimeRequest)

            //Utils.sendNotificationUpcomingReminder(context, datas)

            return Result.success()
        } catch (throwable: Throwable) {
            Log.d("worker failed", "" + throwable.message)
            return Result.failure()
        }
    }
}