package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.lastMatch


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
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.container_shimmer
import kotlinx.android.synthetic.main.fragment_fragment_favorite_match.no_data_movie
import kotlinx.android.synthetic.main.fragment_fragment_last_match.*
import org.jetbrains.anko.toast


class ListLastMatchFragment : BaseFragment(),
    ListLastMatchAdapter.Interaction {
    override fun onItemSelected(position: Int, item: EventsItem) {
        (context as? MainActivity)?.goToDetailEvent(item,this)
    }

    private  val rvAdapter : ListLastMatchAdapter by lazy {
        ListLastMatchAdapter(
            this
        )
    }
    private lateinit var viewModel : ListLastMatchViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fragment_last_match, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val id = (context as? MainActivity)?.id

            viewModel.getLastMatch(id ?: "4328")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()


    }


    private fun setupRecycleView() {
        with(recycleview_last_match){
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
        recycleview_last_match.visibility = View.VISIBLE
        unvVisibleShimmer()
        unVisibleNoData()
    }

    fun unVisibleRvView(){
        recycleview_last_match.visibility = View.GONE
    }






    override fun setupViewModel() {
        viewModel =ViewModelProviders.of(this,viewModelFactory).get(ListLastMatchViewModel::class.java)

        viewModel.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }
            if (it.status == Status.RUNNING) {
                visibleShimmer()

            } else {
                unvVisibleShimmer()

            }

        })

        viewModel.data.observe(this, Observer {
            if (it.events?.size ?: 0 > 0)
                it?.events?.let {
                    rvAdapter.submitList(it)
                    visibleRvView()
                }

            else
                visibleNoData()
        })


    }
}
