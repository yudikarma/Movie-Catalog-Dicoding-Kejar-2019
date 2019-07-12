package com.yudikarma.moviecatalogsubmision2.ui.movie


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_fragment_list_movie.view.*
import org.jetbrains.anko.toast


class FragmentListMovie : BaseFragment(), ListMovieAdapter.OnItemClickListener {
    override fun setupViewModel() {
        model =ViewModelProviders.of(this,viewModelFactory).get(ListMovieViewModel::class.java)

        model.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }
            if (it.status == Status.RUNNING) visibleShimmer() else unvVisibleShimmer()

        })

        model.data.observe(this, Observer {
            it.results?.let {
                data.clear()
                it.forEach() {
                    data.add(it)
                    adapter.notifyDataSetChanged()
                }


            }
        })


    }


    lateinit var mView :View
    private lateinit var adapter : ListMovieAdapter
    private lateinit var data:MutableList<ResultsItem>
    private lateinit var mContext:Context
    private lateinit var model: ListMovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_list_movie, container, false)
        mContext = context

        setupRecycleView()

        model.getListMovie()

        return mView
    }

    private fun setupRecycleView() {
        data = arrayListOf()
        adapter = ListMovieAdapter(mContext, data, this)
        mView.recycleview_listmovie.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listmovie.adapter = adapter


    }

    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
    }



    override fun onItemDetailClick(v: View, position: Int, data: ResultsItem) {
        data.let {
            val action =FragmentListMovieDirections.actionFragmentListMovieToDetailMovieFragment(it)
            Navigation.findNavController(v).navigate(action)
        }


    }
}
