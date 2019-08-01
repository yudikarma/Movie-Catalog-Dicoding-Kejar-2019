package com.yudikarma.moviecatalogsubmision2.feature.ui.tvshow


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.ResultsItemTvShow
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_tv_show.view.*
import org.jetbrains.anko.toast


class ListTvShowFragment : BaseFragment(), ListTvShowAdapter.OnItemClickListener, MaterialSearchView.OnQueryTextListener {
    override fun setupViewModel() {
        model = ViewModelProviders.of(this,viewModelFactory).get(ListTvShowViewModel::class.java)

        model.networkState.observe(this, Observer {
            if (it.status == Status.FAILED){
                context.toast("${it.msg}")
            }

            if (it.status == Status.RUNNING) visibleShimmer() else unvVisibleShimmer()

        })

        model.data.observe(this, Observer {
            it.results?.let {
               adapter.addDataToList(it)

                if (adapter.itemCount == 0) visibleNoData() else UnVisibleNoData()
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
        setHasOptionsMenu(true);
        mView = inflater.inflate(R.layout.fragment_list_tv_show, container, false)
        mContext = context

        setSupportActionbar()

        setupSeachView()

        setupRecycleView()

        model.getListTVShow()

        return mView
    }

    private fun setupRecycleView() {
        data = arrayListOf()
        adapter = ListTvShowAdapter(mContext, data, this)
        mView.recycleview_listtvshow.layoutManager = LinearLayoutManager(mContext)
        mView.recycleview_listtvshow.adapter = adapter


    }

    private fun setSupportActionbar() {
        (activity as AppCompatActivity).supportActionBar
        (activity as AppCompatActivity).setSupportActionBar(mView.toolbar)
    }

    private fun setupSeachView() {
        mView.search_view.setVoiceSearch(false)
        mView.search_view.setEllipsize(true)
        mView.search_view.setOnQueryTextListener(this)

    }

    fun unvVisibleShimmer(){
        mView.container_shimmer.visibility = View.GONE
        mView.recycleview_listtvshow.visibility = View.VISIBLE

    }

    fun visibleShimmer(){
        mView.container_shimmer.visibility = View.VISIBLE
        mView.recycleview_listtvshow.visibility = View.GONE

    }
    fun visibleNoData(){
        mView.no_data_movie.visibility = View.VISIBLE
    }

    fun UnVisibleNoData(){
        mView.no_data_movie.visibility = View.GONE
    }

    override fun onItemDetailClick(v: View, position: Int, data: ResultsItemTvShow) {

        val action = ListTvShowFragmentDirections.actionActionTvshowToDetailTvShowFragment(data)
        Navigation.findNavController(v).navigate(action)

    }
    private fun goToSettingLanguage() {
        val action =ListTvShowFragmentDirections.actionActionTvshowToSettingsFragment()
        Navigation.findNavController(view!!).navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings,menu)
        val item=menu.findItem(R.id.action_search)
        mView.search_view.setMenuItem(item)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings -> {
                goToSettingLanguage()
                return true
            }
            R.id.action_search -> {
                return true
            }
            else -> {
            return super.onOptionsItemSelected(item)
        }
        }
    }
    override fun onQueryTextSubmit(query: String?): Boolean {

        model.searchTVshow(query)
        visibleShimmer()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return true
    }

}
