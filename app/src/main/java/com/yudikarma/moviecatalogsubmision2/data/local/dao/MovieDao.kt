package com.yudikarma.moviecatalogsubmision2.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM MOVIE")
    fun getAllMovie():LiveData<List<MovieEntity>>

    @Insert(onConflict = REPLACE)
    fun insertMovie(movieEntity: MovieEntity)

    @Delete
    fun deleteMovie(movieEntity: MovieEntity)

    @Query("UPDATE MOVIE SET vote_count=:vote_count,popularity =:popularity,vote_average=:vote_average, release_date=:release_date, backdrop_path=:backdrop_path,poster_path=:poster_path, title=:title,original_language=:original_language,overview=:overview WHERE id=:id  ")
    fun updateMovie(id:Long,vote_count:Int,popularity:Double, vote_average:Double,release_date:String, backdrop_path:String,poster_path:String,title:String,original_language:String,overview:String)
}