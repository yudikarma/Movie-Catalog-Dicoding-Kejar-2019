package com.yudikarma.moviecatalogsubmision2.feature.ui

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.work.*
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemMovieUpcoming
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseActivity
import com.yudikarma.moviecatalogsubmision2.feature.broadcastReceiver.ReminderDailyReceiver
import com.yudikarma.moviecatalogsubmision2.feature.broadcastReceiver.ReminderMovieReleaseReceiver
import com.yudikarma.moviecatalogsubmision2.feature.worker.DailyReminderWorker
import com.yudikarma.moviecatalogsubmision2.feature.worker.UpcomingMovieWorker
import com.yudikarma.moviecatalogsubmision2.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainActivity : BaseActivity() {



    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var workManager:WorkManager
    private var data:ArrayList<ResultsItemMovieUpcoming> = arrayListOf()
    private lateinit var viewmodel:MainViewModel
    private lateinit var reminderDailyReceiver: ReminderDailyReceiver
    private lateinit var reminderMovieReleaseReceiver: ReminderMovieReleaseReceiver

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init nav controller
        navController = Navigation.findNavController(this,R.id.main_fragment)
        NavigationUI.setupWithNavController(bottom_nav,navController)
        workManager = WorkManager.getInstance(this)
        reminderDailyReceiver = ReminderDailyReceiver()
        reminderMovieReleaseReceiver = ReminderMovieReleaseReceiver()

        //call get data upcoming movie
        viewmodel.getUpcomingMovie()

        setupRunnngWorker()


    }

    private fun setupRunnngWorker() {
        val result = repository.getBoolean(AppPreferenceHelper.PREF_UPCOMING_REMINDE)
        Log.d("settingan daily ",result.toString())
        if (repository.getBoolean(AppPreferenceHelper.PREF_UPCOMING_REMINDE))/* setupWorkerDailyReminder()*/reminderDailyReceiver.setAlarm(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

    private fun setupWorkerDailyReminder() {
        val constraint = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val currentDate = Calendar.getInstance()

        //untuk jam 7 pagi
        val dueDate = Calendar.getInstance()

        // Set Execution around 07:00:00 AM
        dueDate.set(Calendar.HOUR_OF_DAY, 7)
        dueDate.set(Calendar.MINUTE, 0)
        dueDate.set(Calendar.SECOND, 0)

        //untuk jam 8 pagi
        val dueDate2 = Calendar.getInstance()

        // Set Execution around 07:00:00 AM
        dueDate2.set(Calendar.HOUR_OF_DAY, 8)
        dueDate2.set(Calendar.MINUTE, 0)
        dueDate2.set(Calendar.SECOND, 0)

        if (dueDate.before(currentDate) || dueDate2.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24)
            dueDate2.add(Calendar.HOUR_OF_DAY,24)
        }
        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis

        val timeDiff2 = dueDate2.timeInMillis - currentDate.timeInMillis




        //untuk jam 7 pagi
        val periodicWorkRequest = PeriodicWorkRequest.Builder(DailyReminderWorker::class.java, 24, TimeUnit.HOURS)
            .setConstraints(constraint)
            .setInitialDelay(timeDiff,TimeUnit.MILLISECONDS)
            .build()

        //untuk jam 8 pagi
        val periodicWorkRequest2 = PeriodicWorkRequest.Builder(DailyReminderWorker::class.java, 24, TimeUnit.HOURS)
            .setConstraints(constraint)
            .setInitialDelay(timeDiff2,TimeUnit.MILLISECONDS)
            .build()

        //untuk jam 7 pagi
        workManager.enqueue(periodicWorkRequest)

        //untuk jam 8 pagi
        workManager.enqueue(periodicWorkRequest2)

    }

    private fun setupUpcomingyReminder() {

        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()

        // Set Execution around 07:00:00 AM
        dueDate.set(Calendar.HOUR_OF_DAY, 7)
        dueDate.set(Calendar.MINUTE, 0)
        dueDate.set(Calendar.SECOND, 0)

        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24)
        }
        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis

        val constraint = Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val mapstring = Utils.serializeToJson(data)

        val dataBuilder = Data.Builder()
        dataBuilder.putString("map",mapstring)

        val datas :Data = dataBuilder.build()

        val mPeriodicWorkRequest = PeriodicWorkRequest.Builder(UpcomingMovieWorker::class.java,24,TimeUnit.HOURS)
            .setConstraints(constraint)
            .setInputData(datas)
            .setInitialDelay(timeDiff,TimeUnit.MILLISECONDS)
            .build()

        workManager.enqueue(mPeriodicWorkRequest)
    }


    override fun setupViewModel() {
        viewmodel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)

        viewmodel.networkState.observe(this, androidx.lifecycle.Observer {
            if (it.status == Status.FAILED){
                toast("${it.msg}")
            }
           // if (it.status == Status.RUNNING) visibleShimmer() else unvVisibleShimmer()

        })

        viewmodel.data.observe(this, androidx.lifecycle.Observer {
            it.results?.let {

                val dateFormat =SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val date = Date()
                val now = dateFormat.format(date)

                Log.d("now ",now.toString())


                it.forEach {
                    if (it.release_date.equals(now)){
                        data.add(it)

                       // Log.d("movie rilis today",it.toString())
                    }
                    //Log.d("movie rilis ",it.toString())

                }
                val result = repository.getBoolean(AppPreferenceHelper.PREF_DAILY_REMINDER) && data.size != 0
                Log.d("settingan release ",result.toString())
                if (repository.getBoolean(AppPreferenceHelper.PREF_DAILY_REMINDER) && data.size != 0) reminderMovieReleaseReceiver.setAlarm(this,data)/*setupUpcomingyReminder()*/


            }
        })

    }



}
