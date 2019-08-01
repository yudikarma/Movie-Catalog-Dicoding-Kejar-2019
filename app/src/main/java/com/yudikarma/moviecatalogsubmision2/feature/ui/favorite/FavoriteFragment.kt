package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie.FavoriteMovieFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteTvShow.FavoriteTvShowFragment
import kotlinx.android.synthetic.main.fragment_favorite.view.*


class FavoriteFragment : Fragment() {

    private lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_favorite, container, false)

        mView.viewpager.adapter = FavoriteFragmentAdapter(childFragmentManager)
        mView.tablayout.setupWithViewPager(mView.viewpager)

        return mView
    }

    inner class FavoriteFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        val pages = listOf(FavoriteMovieFragment(),FavoriteTvShowFragment())

        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 ->getString(R.string.favorite_movie)
                else -> getString(R.string.favorite_tv_show)
            }
        }

    }


}
