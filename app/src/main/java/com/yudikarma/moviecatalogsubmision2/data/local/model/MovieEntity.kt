package com.yudikarma.moviecatalogsubmision2.data.local.model

import android.database.Cursor
import android.net.Uri
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import android.R.attr.name
import android.R.id
import android.content.ContentValues
import android.provider.BaseColumns
import androidx.room.Ignore


@Parcelize
@Entity(tableName = "MOVIE")
data class MovieEntity(@ColumnInfo(name = "overview")  var overview:String,
                       @ColumnInfo(name = "original_language")  var original_language:String,
                       @ColumnInfo(name = "title") var title:String,
                       @ColumnInfo(name = "poster_path") var poster_path:String ,
                       @ColumnInfo(name = "backdrop_path") var backdrop_path:String= "",
                       @ColumnInfo(name = "release_date") var release_date:String,
                       @ColumnInfo(name = "vote_average") var vote_average:Double,
                       @ColumnInfo(name = "popularity") var popularity:Double,
                       @ColumnInfo(name = "vote_count") var vote_count:Int,
                       @ColumnInfo(name = "getCountFavorite") var isFavorite:Boolean,
                       @PrimaryKey @ColumnInfo(name = "id") var id:Long =0 ):Parcelable {
    //constructor() : this("","","","","","",0.0,0.0,0,false,0)

    companion object {
       const val TABLE_NAME = "MOVIE"
        const val idd = "id"
        val isFavorited = "getCountFavorite"
        val vote_countd = "vote_count"
        val popularityd = "popularity"
        val vote_averaged = "vote_average"
       val release_dated = "release_date"
       val backdrop_pathd = "backdrop_path"
       val poster_pathd = "poster_path"
       val titled = "title"
       val original_languaged = "original_language"
       val overviewd = "overview"

        fun fromContentValues(values: ContentValues): MovieEntity {
            var movieEntity:MovieEntity? = null

            if (values.containsKey(idd)) {
                movieEntity?.id = values.getAsLong(idd)
            }
            if (values.containsKey(isFavorited)) {
                movieEntity?.isFavorite = values.getAsBoolean(isFavorited)
            }
            if (values.containsKey(vote_countd)) {
                movieEntity?.vote_count = values.getAsInteger(vote_countd)
            }
            if (values.containsKey(popularityd)) {
                movieEntity?.popularity = values.getAsDouble(popularityd)
            }
            if (values.containsKey(vote_averaged)) {
                movieEntity?.vote_average = values.getAsDouble(vote_averaged)
            }
            if (values.containsKey(release_dated)) {
                movieEntity?.release_date = values.getAsString(release_dated)
            }
            if (values.containsKey(backdrop_pathd)) {
                movieEntity?.backdrop_path = values.getAsString(backdrop_pathd)
            }
            if (values.containsKey(poster_pathd)) {
                movieEntity?.poster_path = values.getAsString(poster_pathd)
            }
            if (values.containsKey(titled)) {
                movieEntity?.title = values.getAsString(titled)
            }
            if (values.containsKey(original_languaged)) {
                movieEntity?.original_language = values.getAsString(original_languaged)
            }
            if (values.containsKey(overviewd)) {
                movieEntity?.overview = values.getAsString(overviewd)
            }
            return movieEntity!!
        }
    }


}