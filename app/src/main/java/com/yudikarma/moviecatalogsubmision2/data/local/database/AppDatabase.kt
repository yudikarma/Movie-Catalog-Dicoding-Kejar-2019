package com.yudikarma.moviecatalogsubmision2.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.yudikarma.moviecatalogsubmision2.data.local.dao.MovieDao
import com.yudikarma.moviecatalogsubmision2.data.local.dao.TVShowDao
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import androidx.room.Room
import android.R.attr.name
import com.orhanobut.hawk.Hawk.count






@Database(
    entities = [(MovieEntity::class),(TvShowEntity::class)],
    version = 1, exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    @SuppressWarnings("WeakerAccess")
    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TVShowDao


    /*@Synchronized
    fun getInstance(context: Context): AppDatabase {
        if (sInstance == null) {
            sInstance = Room
                .databaseBuilder(context.getApplicationContext(), AppDatabase::class.java!!, "")
                .build()
        }
        return sInstance!!
    }*/

    companion object{
        private var sInstance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java!!, "FavoriteMovie.db")
                    .build()

            }
            return sInstance!!
        }

    }


}