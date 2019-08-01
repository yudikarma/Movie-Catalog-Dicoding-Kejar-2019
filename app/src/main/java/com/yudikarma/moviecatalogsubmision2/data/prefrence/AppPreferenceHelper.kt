package com.yudikarma.moviecatalogsubmision2.data.prefrence

import com.orhanobut.hawk.Hawk
import com.yudikarma.moviecatalogsubmision2.di.PreferenceInfo
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(@PreferenceInfo private val prefFileName : String):PreferenceHelper {

    companion object{
        const val PREF_DAILY_REMINDER = "PREF_DAILY_REMINDER"
        const val PREF_UPCOMING_REMINDE = "PREF_UPCOMING_REMINDE"

    }
    override fun setBoolean(key: String, value: Boolean?) {
        Hawk.put(key,value)
    }

    override fun getBoolean(key: String): Boolean = Hawk.get(key,false)
}