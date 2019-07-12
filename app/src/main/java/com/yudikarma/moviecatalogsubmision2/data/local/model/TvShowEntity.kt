package com.yudikarma.moviecatalogsubmision2.data.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "TVShow")
data class TvShowEntity(@ColumnInfo(name = "first_air_date") var first_air_date:String,
                       @ColumnInfo(name = "overview") var overview:String,
                       @ColumnInfo(name = "original_language") var original_language:String,
                       @ColumnInfo(name = "poster_path") var poster_path:String,
                       @ColumnInfo(name = "backdrop_path") var backdrop_path:String,
                       @ColumnInfo(name = "original_name") var original_name:String,
                       @ColumnInfo(name = "popularity") var popularity:Double,
                       @ColumnInfo(name = "vote_average") var vote_average:Double,
                        @ColumnInfo(name = "name")var name:String,
                       @ColumnInfo(name = "vote_count") var vote_count:Int,
                       @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id:Long = 0): Parcelable {
}