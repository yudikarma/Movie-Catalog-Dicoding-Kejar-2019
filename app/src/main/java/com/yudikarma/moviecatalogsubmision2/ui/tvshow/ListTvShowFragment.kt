package com.yudikarma.moviecatalogsubmision2.ui.tvshow


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.adapter.ListTvShowAdapter
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItem
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.ui.movie.FragmentListMovieDirections
import com.yudikarma.moviecatalogsubmision2.ui.movie.ListMovieViewModel
import kotlinx.android.synthetic.main.fragment_list_tv_show.view.*
import org.jetbrains.anko.toast


class ListTvShowFragment : BaseFragment(),ListTvShowAdapter.OnItemClickListener {
    override fun setupViewModel() {
        model = ViewModelProviders.of(this,viewModelFactory).get(ListTvShowViewModel::class.java)

        model.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }
        })

        model.data.observe(this, Observer {
            it.results?.let {
                data.clear()
                it?.forEach() {
                    data.add(it)
                    adapter.notifyDataSetChanged()
                }
            }
        })

    }

    lateinit var mView :View
    private lateinit var adapter : ListTvShowAdapter
    private lateinit var data:MutableList<ResultsItemTvShow>
    private lateinit var mContext: Context
    private lateinit var model: ListTvShowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_list_tv_show, container, false)
        mContext = context ?: return mView

        setupRecycleView()

        model.getListTVShow()

        return mView
    }

    private fun setupRecycleView() {
        data = arrayListOf()
        adapter = ListTvShowAdapter(mContext , data, this)
        mView.recycleview_listtvshow.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listtvshow.adapter = adapter


    }

    override fun onItemDetailClick(v: View, position: Int, data: ResultsItemTvShow) {

        val action = ListTvShowFragmentDirections.actionActionTvshowToDetailTvShowFragment(data)
        Navigation.findNavController(v).navigate(action)

    }

}
