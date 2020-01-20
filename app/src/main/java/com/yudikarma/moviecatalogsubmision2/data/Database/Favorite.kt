package com.yudikarma.moviecatalogsubmision2.data.Database

data class Favorite(val id: Long? = 0, val eventId: String? = "", val dateEvent: String? = "", val homeTeam: String? = "", val homeScore: String? = "",
                    val awayTeam: String? = "", val awayScore: String? = "") {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val EVENT_ID: String = "EVENT_ID"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val HOME_TEAM: String = "HOME_TEAM"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_TEAM: String = "AWAY_TEAM"
        const val AWAY_SCORE: String = "AWAY_SCORE"
    }
}