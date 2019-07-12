package com.yudikarma.moviecatalogsubmision2.data.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "MOVIE")
data class MovieEntity(@ColumnInfo(name = "overview") var overview:String,
                       @ColumnInfo(name = "original_language") var original_language:String,
                       @ColumnInfo(name = "title") var title:String,
                       @ColumnInfo(name = "poster_path") var poster_path:String,
                       @ColumnInfo(name = "backdrop_path") var backdrop_path:String,
                       @ColumnInfo(name = "release_date") var release_date:String,
                       @ColumnInfo(name = "vote_average") var vote_average:Double,
                       @ColumnInfo(name = "popularity") var popularity:Double,
                       @ColumnInfo(name = "vote_count") var vote_count:Int,
                       @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id:Long = 0):Parcelable {
}