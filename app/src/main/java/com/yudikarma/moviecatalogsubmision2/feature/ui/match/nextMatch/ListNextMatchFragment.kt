package com.yudikarma.moviecatalogsubmision2.feature.ui.match.nextMatch


import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import com.yudikarma.moviecatalogsubmision2.utils.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.*
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.container_shimmer
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.no_data_movie
import kotlinx.android.synthetic.main.fragment_fragment_next_match.*
import org.jetbrains.anko.toast


class ListNextMatchFragment : BaseFragment(),
    ListNextMatchAdapter.Interaction {

    override fun onItemSelected(position: Int, item: EventsItem) {
        (context as? MainActivity)?.goToDetailEvent(item,this)

    }

    override fun setupViewModel() {
        model = ViewModelProviders.of(this,viewModelFactory).get(ListNextMatchViewModel::class.java)

        model.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }

            if (it.status == Status.RUNNING){
                visibleShimmer()

            } else {
                unvVisibleShimmer()

            }

        })

        model.data.observe(this, Observer {
            if (it.events?.size?: 0 > 0){
                it?.events?.let {
                    rvAdapter.submitList(it)
                    visibleRvView()
                }
            }else{
                visibleNoData()
            }
        })

    }


    private  val rvAdapter : ListNextMatchAdapter by lazy {
        ListNextMatchAdapter(
            this
        )
    }
    private lateinit var model: ListNextMatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            val id = (context as? MainActivity)?.id
            EspressoIdlingResource.increment()
            model.getListNextMatch(id?:"4328")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        return  inflater.inflate(R.layout.fragment_fragment_next_match, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
    }

    private fun setupRecycleView() {

        with(recycleview_next_match){
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
        recycleview_next_match.visibility = View.VISIBLE
        unVisibleNoData()
        unvVisibleShimmer()
    }

    fun unVisibleRvView(){
        recycleview_next_match.visibility = View.GONE
    }



}
