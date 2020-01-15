package com.yudikarma.moviecatalogsubmision2.feature.ui.Liga.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListLigaModel (val name: String?, val description: String?, val image: Int?,val id:String?) : Parcelable
