package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.favoriteMatch.FavoriteMatchFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.lastMatch.ListLastMatchFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.nextMatch.ListNextMatchFragment

class DashboardAdapter internal constructor(fm: FragmentManager, val context: Context):
    FragmentStatePagerAdapter(fm){

    private val pages = listOf<Fragment>(
        ListLastMatchFragment(),
        ListNextMatchFragment(),
        FavoriteMatchFragment()
    )

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Last Match"
            1 -> "Next Match"
            else -> "Favorite Match"
        }
    }
}