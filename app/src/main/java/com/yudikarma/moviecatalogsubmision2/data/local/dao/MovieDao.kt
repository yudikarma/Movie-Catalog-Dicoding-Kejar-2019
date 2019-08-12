package com.yudikarma.moviecatalogsubmision2.data.local.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM MOVIE")
    fun getAllMovie():LiveData<List<MovieEntity>>

    @Query("SELECT * FROM MOVIE")
    fun getAllMoviesuspend():List<MovieEntity>

    @Query("SELECT * FROM " + MovieEntity.TABLE_NAME)
    fun getAll():Cursor

    @Query("SELECT * FROM MOVIE WHERE "+MovieEntity.idd+" = :id")
    fun selectById(id: Long):Cursor

    @Insert(onConflict = REPLACE)
    fun insertMovie(movieEntity: MovieEntity):Long

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM MOVIE WHERE id=:id")
    fun deleteById(id: Long):Int

    @Query("SELECT COUNT(*) FROM MOVIE where id=:id")
    fun getCountFavorite(id:Long) :Int /*check is this id already add to favorite*/

    @Update
    fun updateMovie(movieEntity: MovieEntity):Int

    @Query("SELECT COUNT(*) FROM MOVIE")
    fun countMovie():Int

    @Query("SELECT * FROM MOVIE")
    fun selectAllMovieCursor():Cursor

    /*@Delete
    fun deleteMovieCursor(movieEntity: MovieEntity) :Cursor*/

  }