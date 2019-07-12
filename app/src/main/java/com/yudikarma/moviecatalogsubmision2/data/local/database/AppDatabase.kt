package com.yudikarma.moviecatalogsubmision2.data.local.database

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.yudikarma.moviecatalogsubmision2.data.local.dao.MovieDao
import com.yudikarma.moviecatalogsubmision2.data.local.dao.TVShowDao
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity


@Database(
    entities = [(MovieEntity::class),(TvShowEntity::class)],
    version = 1, exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {

    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TVShowDao
}