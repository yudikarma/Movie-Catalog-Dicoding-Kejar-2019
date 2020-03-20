package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.team


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.Team
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_search_team.*
import org.jetbrains.anko.toast

/**
 * A simple [Fragment] subclass.
 */
class SearchTeamFragment : BaseFragment(), SearchTeamRvAdapter.Interaction {
    override fun onItemSelected(position: Int, item: Team) {

    }

    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(SearchTeamViewModel::class.java)
        viewModel.data.observe(this, Observer {
            if (it.teams.size != 0){
                onLoadData()
            }else{
                onDataNull()
            }
        })

        viewModel.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }

            if (it.status == Status.RUNNING){
                showShimmer()

            } else {
                onLoadData()

            }

        })
    }

    private lateinit var viewModel:SearchTeamViewModel

    private val mAdapter :SearchTeamRvAdapter by lazy { SearchTeamRvAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_team, container, false)
    }


    fun onLoadData(){
        rv_team.visibility = View.VISIBLE
        no_data_.visibility = View.GONE
        container_shimmer.visibility = View.GONE
    }

    fun onDataNull(){
        rv_team.visibility = View.GONE
        no_data_.visibility = View.VISIBLE
        container_shimmer.visibility = View.GONE
    }

    fun showShimmer(){
        rv_team.visibility = View.GONE
        no_data_.visibility = View.GONE
        container_shimmer.visibility = View.VISIBLE
    }




}
