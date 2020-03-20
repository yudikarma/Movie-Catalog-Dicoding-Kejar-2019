package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardAdapter
import kotlinx.android.synthetic.main.fragment_container_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class ContainerFavoriteFragment : Fragment() {

    private  val tabsAdapter: DashboardAdapter by lazy {
        DashboardAdapter(
            childFragmentManager,
            context!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_container_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewpager){
            adapter  = tabsAdapter
        }
        with(tablayout){
            setupWithViewPager(viewpager)
        }
    }

}
