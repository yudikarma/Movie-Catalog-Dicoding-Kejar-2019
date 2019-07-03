package com.yudikarma.moviecatalogsubmision2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie( val id:String = "",
                  val poster: String = "",
                  val name:String = "",
                  val rilis:String = "",
                  val description:String = "",
                  val rating:String = "") : Parcelable