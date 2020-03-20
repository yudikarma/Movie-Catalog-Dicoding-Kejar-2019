package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteMatch.FavoriteMatchFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam.TeamFavoriteFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.lastMatch.ListLastMatchFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.nextMatch.ListNextMatchFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.team.TeamFragment

class ContainerFavoriteAdapter internal constructor(fm: FragmentManager, val context: Context):
    FragmentStatePagerAdapter(fm){

    private val pages = listOf<Fragment>(
        TeamFavoriteFragment(),
        FavoriteMatchFragment()
    )

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Favorite Team"
            else -> "Favorite Match"
        }
    }
}