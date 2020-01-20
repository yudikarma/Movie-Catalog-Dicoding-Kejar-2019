package com.yudikarma.moviecatalogsubmision2.feature.ui.match.favoriteMatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Database.Favorite
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.*


class FavoriteMatchFragment : BaseFragment(), FavoriteMatchRvAdapter.Interaction {
    override fun onItemSelected(position: Int, itemm: Favorite) {
        itemm?.let {
            val items = EventsItem(idEvent = it.eventId?:"")
            (context as? MainActivity)?.goToDetailEvent(items,this)
        }
    }

    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(FavoriteMatchViewModel::class.java)

        viewModel.data.observe(this, Observer {
            if (it?.size ?: 0 > 0)
                it?.let {
                    rvAdapter.submitList(it)
                    visibleRvView()
                }

            else
                visibleNoData()
        })
    }

    private  val rvAdapter : FavoriteMatchRvAdapter by lazy {
        FavoriteMatchRvAdapter(
            this
        )
    }
    private lateinit var viewModel : FavoriteMatchViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_favorite_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        viewModel.getFavoriteMatch()
        unvVisibleShimmer()
    }

    private fun setupRecycleView() {
        with(recycleview_favorite_match){
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
        }
    }


    fun unvVisibleShimmer(){
        container_shimmer.visibility = View.GONE

    }

    fun visibleShimmer(){
        container_shimmer.visibility = View.VISIBLE
        unVisibleRvView()
        unVisibleNoData()
    }

    fun visibleNoData(){
        no_data_movie.visibility = View.VISIBLE
        unVisibleRvView()
        unvVisibleShimmer()
    }

    fun unVisibleNoData(){
        no_data_movie.visibility = View.GONE
    }

    fun visibleRvView(){
        recycleview_favorite_match.visibility = View.VISIBLE
        unVisibleNoData()
        unvVisibleShimmer()
    }

    fun unVisibleRvView(){
        recycleview_favorite_match.visibility = View.GONE
    }




}
