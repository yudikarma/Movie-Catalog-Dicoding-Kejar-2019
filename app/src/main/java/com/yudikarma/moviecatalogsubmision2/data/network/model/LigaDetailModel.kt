package com.yudikarma.moviecatalogsubmision2.data.network.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class LeaguesItem(@SerializedName("strDescriptionES")
                       val strDescriptionES: String = "",
                       @SerializedName("strBanner")
                       val strBanner: String = "",
                       @SerializedName("strSport")
                       val strSport: String = "",
                       @SerializedName("strDescriptionIT")
                       val strDescriptionIT: String = "",
                       @SerializedName("idLeague")
                       val idLeague: String = "",
                       @SerializedName("strBadge")
                       val strBadge: String = "",
                       @SerializedName("strLogo")
                       val strLogo: String = "",
                       @SerializedName("strLeague")
                       val strLeague: String = "",
                       @SerializedName("strPoster")
                       val strPoster: String = ""):Parcelable


@Parcelize
data class LigaDetailModel(@SerializedName("leagues")
                           val leagues: List<LeaguesItem>?):Parcelable


