package com.yudikarma.moviecatalogsubmision2.data.prefrence

interface PreferenceHelper {
    fun setBoolean(key:String,value: Boolean?)

    fun getBoolean(key: String):Boolean
}