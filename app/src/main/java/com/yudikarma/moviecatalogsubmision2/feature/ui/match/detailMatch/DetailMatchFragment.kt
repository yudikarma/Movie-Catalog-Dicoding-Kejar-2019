package com.yudikarma.moviecatalogsubmision2.feature.ui.match.detailMatch


import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.like.LikeButton
import com.like.OnLikeListener

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Database.Favorite
import com.yudikarma.moviecatalogsubmision2.data.Database.database
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.utils.EspressoIdlingResource
import com.yudikarma.moviecatalogsubmision2.utils.loadImage
import kotlinx.android.synthetic.main.fragment_detail_march.*
import kotlinx.android.synthetic.main.fragment_detail_march.view.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.toast

class DetailMatchFragment : BaseFragment() {


    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailMatchViewModel::class.java)

        viewModel.data.observe(this, Observer {
            it?.events?.get(0)?.let {
                EspressoIdlingResource.increment()
                setupViewDetail(it)
                EspressoIdlingResource.increment()
                viewModel.getTeamInfoHome(it.idHomeTeam)
                EspressoIdlingResource.increment()
                viewModel.getTeamInfoAway(it.idAwayTeam)
            }
        })

        viewModel.dataTeamHome.observe(this, Observer {
            logo_team_home.loadImage("${it.teams?.get(0)?.strTeamBadge}/preview")
        })

        viewModel.dataTeamAway.observe(this, Observer {
            logo_team_away.loadImage("${it.teams?.get(0)?.strTeamBadge}/preview")
        })

        viewModel.networkState.observe(this, androidx.lifecycle.Observer {
            if (it.status == Status.FAILED){
                toast("${it.msg}")
            }
            if (it.status == Status.RUNNING){

            } else {

            }

        })


    }


    lateinit var viewModel: DetailMatchViewModel
    private var id = ""
    private var favoriteModel = Favorite()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val safeVarargs : DetailMatchFragmentArgs by navArgs()


        val eventsItem = safeVarargs.event
        val eventsItem2 = safeVarargs.event2

        if (eventsItem == EventsItem()){
            if (savedInstanceState == null){
                eventsItem2?.let {
                    id = it.idEvent
                    EspressoIdlingResource.increment()
                    viewModel.getDetailMatch(it.idEvent)

                }
            }
        }else{
            if (savedInstanceState == null){
                eventsItem?.let {
                    id = it.idEvent
                    EspressoIdlingResource.increment()
                    viewModel.getDetailMatch(it.idEvent)
                }
            }
        }
        return inflater.inflate(R.layout.fragment_detail_march, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setEnableFavoriteState(false)

        btn_favorite.setOnLikeListener(object : OnLikeListener{
            override fun liked(likeButton: LikeButton?) {
                addFavorite()
            }

            override fun unLiked(likeButton: LikeButton?) {
                removeFavorite()
            }

        })

    }


     fun setupViewDetail(resultsItem: EventsItem) {
         //logo_team_1.loadImage(resultsItem.strThumb+"/preview")
         val homeTeam = if (resultsItem.strHomeTeam == null) "-" else "${resultsItem.strHomeTeam}"
         name_team_1.text = homeTeam
         name_team_1_detail.text = homeTeam
         val awayTeam = if (resultsItem.strAwayTeam == null) "-" else "${resultsItem.strAwayTeam}"
         name_team_2.text = awayTeam
         name_team_2_detail.text = awayTeam

         val homeSccore = if (resultsItem.intHomeScore == null) "-" else "${resultsItem.intHomeScore}"
         score_team_1.text = homeSccore
         val awayScore = if (resultsItem.intAwayScore == null) "-" else "${resultsItem.intAwayScore}"
         score_team_2.text = awayScore

         val homeShot = if (resultsItem.intHomeShots == null) "-" else "${resultsItem.intHomeShots}"
         txt_value_shot_on_target_home.text = homeShot
         val awayShot = if (resultsItem.intAwayShots == null)"-" else "${resultsItem.intAwayShots}"
         txt_value_shot_on_target_away.text = awayShot

         val homeFormation = if (resultsItem.strHomeFormation == null) "-" else "${resultsItem.strHomeFormation}"
         txt_value_formation_home.text = homeFormation
         val awayFormation = if (resultsItem.strAwayFormation == null) "-" else "${resultsItem.strAwayFormation}"
         txt_value_formation_away.text = awayFormation

         val goalHome = if (resultsItem.strHomeGoalDetails == null) "-" else "${resultsItem.strHomeGoalDetails}"
         txt_value_goal_home.text = goalHome
         val goalAway = if (resultsItem.strAwayGoalDetails == null) "-" else "${resultsItem.strAwayGoalDetails}"
         txt_value_goal_away.text = goalAway

         val homeYellowCard = if(resultsItem.strHomeYellowCards == null) "-" else "${resultsItem.strHomeYellowCards}"
         txt_value_yellow_card_home.text = homeYellowCard
         val awayYellowCard = if (resultsItem.strAwayYellowCards == null)"-" else "${resultsItem.strAwayYellowCards}"
         txt_value_yellow_card_away.text = awayYellowCard

         val redCardHome= if (resultsItem.strHomeRedCards == null) "=" else "${resultsItem.strHomeRedCards}"
         txt_value_red_card_home.text = redCardHome
         val redCardAway = if (resultsItem.strAwayRedCards == null) "-" else "${resultsItem.strAwayRedCards}"
         txt_value_red_card_away.text = redCardAway


         favoriteState()
         /*
         val id: Long? = 0, val eventId: String? = "", val dateEvent: String? = "", val homeTeam: String? = "", val homeScore: String? = "",
                    val awayTeam: String? = "", val awayScore: String? = ""
         * */
         favoriteModel = Favorite(eventId = resultsItem.idEvent,
             dateEvent = resultsItem.dateEvent, homeTeam =  resultsItem.strHomeTeam,homeScore = resultsItem.intHomeScore,
             awayTeam = resultsItem.strAwayTeam,awayScore = resultsItem.intAwayScore)

         setEnableFavoriteState(true)


     }

    private fun favoriteState() {
        context.database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs(
                    "(EVENT_ID = {id})",
                    "id" to id
                )
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()) btn_favorite.isLiked = true
        }
    }

    private fun addFavorite(){
        try {
            context.database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.EVENT_ID to favoriteModel.eventId,
                    Favorite.DATE_EVENT to favoriteModel.dateEvent,
                    Favorite.HOME_TEAM to favoriteModel.homeTeam,
                    Favorite.HOME_SCORE to favoriteModel.homeScore,
                    Favorite.AWAY_TEAM to favoriteModel.awayTeam,
                    Favorite.AWAY_SCORE to favoriteModel.awayScore
                )
            }
            setFavoriteState(true)
            toast("Added to favorite")
        } catch (e: SQLiteConstraintException) {
           toast(e.localizedMessage)
            setFavoriteState(false)
        }
    }

    private fun removeFavorite(){
        try {
            context.database.use {
                delete(
                    Favorite.TABLE_FAVORITE, "(EVENT_ID = {id})",
                    "id" to id
                )
            }
            toast("Removed to favorite").show()
            setFavoriteState(false)
        } catch (e: SQLiteConstraintException) {
            toast(e.localizedMessage).show()
            setFavoriteState(true)
        }
    }

    fun setFavoriteState(isFavorite:Boolean){
        btn_favorite.isLiked = isFavorite
    }

    fun setEnableFavoriteState(isEnable:Boolean){
        btn_favorite.isEnabled = isEnable
    }


}
