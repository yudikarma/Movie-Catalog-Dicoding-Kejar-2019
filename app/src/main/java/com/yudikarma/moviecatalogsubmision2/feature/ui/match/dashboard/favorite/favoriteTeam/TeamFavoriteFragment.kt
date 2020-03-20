package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yudikarma.moviecatalogsubmision2.R

/**
 * A simple [Fragment] subclass.
 */
class TeamFavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_favorite, container, false)
    }


}
