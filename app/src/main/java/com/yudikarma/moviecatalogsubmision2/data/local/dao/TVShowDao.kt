package com.yudikarma.moviecatalogsubmision2.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yudikarma.moviecatalogsubmision2.data.local.model.MovieEntity
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity


@Dao
interface TVShowDao {
    @Query("SELECT * FROM TVShow")
    fun getAllTVShow():LiveData<List<TvShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshow(tvShowEntity: TvShowEntity)

    @Delete
    fun deleteTvshow(tvShowEntity: TvShowEntity)

    @Query("UPDATE TVShow SET first_air_date=:first_air_date,overview =:overview,original_language=:original_language, poster_path=:poster_path, backdrop_path=:backdrop_path,original_name=:original_name, popularity=:popularity,vote_average=:vote_average,name=:name,vote_count=:vote_count WHERE id=:id  ")
    fun updateTvshow(id:Long,first_air_date:String,overview:String, original_language:String,poster_path:String, backdrop_path:String,original_name:String,popularity:Double,vote_average:Double,name:String,vote_count:String)
}