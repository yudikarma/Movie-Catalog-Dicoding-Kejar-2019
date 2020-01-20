package com.yudikarma.moviecatalogsubmision2.data.network.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LastMatchModel(@SerializedName("events")
                          val events: List<EventsItem>? = emptyList()):Parcelable


@Parcelize
data class EventsItem(@SerializedName("intHomeShots")
                      val intHomeShots: Int = 0,
                      @SerializedName("strSport")
                      val strSport: String = "",
                      @SerializedName("strHomeLineupDefense")
                      val strHomeLineupDefense: String = "",
                      @SerializedName("strAwayLineupSubstitutes")
                      val strAwayLineupSubstitutes: String = "",
                      @SerializedName("strTweet1")
                      val strTweet1: String = "",
                      @SerializedName("strTweet2")
                      val strTweet2: String = "",
                      @SerializedName("strTweet3")
                      val strTweet3: String = "",
                      @SerializedName("idLeague")
                      val idLeague: String = "",
                      @SerializedName("idSoccerXML")
                      val idSoccerXML: String = "",
                      @SerializedName("strHomeLineupForward")
                      val strHomeLineupForward: String = "",
                      @SerializedName("strTVStation")
                      val strTVStation: String = "",
                      @SerializedName("strHomeGoalDetails")
                      val strHomeGoalDetails: String = "",
                      @SerializedName("strVideo")
                      val strVideo: String = "",
                      @SerializedName("strAwayLineupGoalkeeper")
                      val strAwayLineupGoalkeeper: String = "",
                      @SerializedName("strAwayLineupMidfield")
                      val strAwayLineupMidfield: String = "",
                      @SerializedName("idEvent")
                      val idEvent: String = "",
                      @SerializedName("intRound")
                      val intRound: String = "",
                      @SerializedName("strHomeYellowCards")
                      val strHomeYellowCards: String = "",
                      @SerializedName("idHomeTeam")
                      val idHomeTeam: String = "",
                      @SerializedName("intHomeScore")
                      val intHomeScore: String = "",
                      @SerializedName("dateEvent")
                      val dateEvent: String = "",
                      @SerializedName("strCountry")
                      val strCountry: String = "",
                      @SerializedName("strAwayTeam")
                      val strAwayTeam: String = "",
                      @SerializedName("strHomeLineupMidfield")
                      val strHomeLineupMidfield: String = "",
                      @SerializedName("strDate")
                      val strDate: String = "",
                      @SerializedName("strHomeFormation")
                      val strHomeFormation: String = "",
                      @SerializedName("strMap")
                      val strMap: String = "",
                      @SerializedName("idAwayTeam")
                      val idAwayTeam: String = "",
                      @SerializedName("strAwayRedCards")
                      val strAwayRedCards: String = "",
                      @SerializedName("strBanner")
                      val strBanner: String = "",
                      @SerializedName("strFanart")
                      val strFanart: String = "",
                      @SerializedName("strDescriptionEN")
                      val strDescriptionEN: String = "",
                      @SerializedName("dateEventLocal")
                      val dateEventLocal: String = "",
                      @SerializedName("strResult")
                      val strResult: String = "",
                      @SerializedName("strCircuit")
                      val strCircuit: String = "",
                      @SerializedName("intAwayShots")
                      val intAwayShots: String = "",
                      @SerializedName("strFilename")
                      val strFilename: String = "",
                      @SerializedName("strTime")
                      val strTime: String = "",
                      @SerializedName("strAwayGoalDetails")
                      val strAwayGoalDetails: String = "",
                      @SerializedName("strAwayLineupForward")
                      val strAwayLineupForward: String = "",
                      @SerializedName("strTimeLocal")
                      val strTimeLocal: String = "",
                      @SerializedName("strLocked")
                      val strLocked: String = "",
                      @SerializedName("strSeason")
                      val strSeason: String = "",
                      @SerializedName("intSpectators")
                      val intSpectators: Int = 0,
                      @SerializedName("strEventAlternate")
                      val strEventAlternate: String = "",
                      @SerializedName("strHomeRedCards")
                      val strHomeRedCards: String = "",
                      @SerializedName("strHomeLineupGoalkeeper")
                      val strHomeLineupGoalkeeper: String = "",
                      @SerializedName("strHomeLineupSubstitutes")
                      val strHomeLineupSubstitutes: String = "",
                      @SerializedName("strAwayFormation")
                      val strAwayFormation: String = "",
                      @SerializedName("strEvent")
                      val strEvent: String = "",
                      @SerializedName("strAwayYellowCards")
                      val strAwayYellowCards: String = "",
                      @SerializedName("strAwayLineupDefense")
                      val strAwayLineupDefense: String = "",
                      @SerializedName("strHomeTeam")
                      val strHomeTeam: String = "",
                      @SerializedName("strThumb")
                      val strThumb: String = "",
                      @SerializedName("strLeague")
                      val strLeague: String = "",
                      @SerializedName("intAwayScore")
                      val intAwayScore: String = "",
                      @SerializedName("strCity")
                      val strCity: String = "",
                      @SerializedName("strPoster")
                      val strPoster: String = ""):Parcelable


