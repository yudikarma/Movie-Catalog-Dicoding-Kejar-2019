package com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteTvShow


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.local.model.TvShowEntity
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorite_tv_show.view.*
import org.jetbrains.anko.toast


class FavoriteTvShowFragment : BaseFragment(), FavoriteTvShowAdapter.OnItemClickListener {
    override fun onItemDeleteClick(v: View, data: TvShowEntity) {
        model.deleteTVshow(data)
        adapter.notifyDataSetChanged()
        context.toast("Succes delete item")


    }

    override fun setupViewModel() {
        model = ViewModelProviders.of(this,viewModelFactory).get(FavoriteTvShowViewModel::class.java)

        model.data.observe(this, Observer {
            data.clear()
            data.addAll(it)
            adapter.notifyDataSetChanged()
            unvVisibleShimmer()
        })
    }
    lateinit var mView :View
    private lateinit var adapter : FavoriteTvShowAdapter
    private lateinit var data:MutableList<TvShowEntity>
    private lateinit var mContext: Context
    private lateinit var model: FavoriteTvShowViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_favorite_tv_show, container, false)
        mContext = context

        visibleShimmer()
        model.getAllFavoriteTVshow()
        setupRecycleView()

        return mView
    }

    private fun setupRecycleView() {
        data  = arrayListOf()
        adapter = FavoriteTvShowAdapter(mContext,data,this)
        mView.recycleview_listtvshow.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listtvshow.adapter = adapter

    }
    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
    }


}
