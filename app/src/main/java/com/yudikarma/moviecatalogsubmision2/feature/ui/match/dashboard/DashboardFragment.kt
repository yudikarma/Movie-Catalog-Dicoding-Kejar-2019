package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItemMatchByName
import com.yudikarma.moviecatalogsubmision2.data.network.model.LeaguesItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import com.yudikarma.moviecatalogsubmision2.utils.loadImage
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast


class DashboardFragment : BaseFragment() , MaterialSearchView.OnQueryTextListener,
SearchMatchRvAdapter.Interaction,
MaterialSearchView.SearchViewListener {

    override fun onSearchViewClosed() {
        visibleFragment()
    }

    override fun onSearchViewShown() {
        visibleRvView()

    }

    private val rvAdapter: SearchMatchRvAdapter by lazy {
        SearchMatchRvAdapter(
            this
        )
    }



    companion object{
        fun goToDetailEvent(eventsItem: EventsItem = EventsItem(), eventsItem2: EventsItemMatchByName = EventsItemMatchByName(), fragment: Fragment? = null){
            val action =
                DashboardFragmentDirections.actionFragmentListMovieToDetailMovieFragment(
                    eventsItem,eventsItem2
                )
            if (fragment != null){
                fragment?.let {
                    findNavController(fragment).navigate(action)
                }
            }


        }






    }

    override fun setupViewModel() {
        dashboardViewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel::class.java)

        dashboardViewModel.data.observe(this, Observer {
            it?.leagues?.let {
                setupViewDetailLiga(it.get(0))
            }
        })

        dashboardViewModel.dataMatchByName.observe(this,androidx.lifecycle.Observer {
            if (it.events?.size ?: 0 > 0){

                val list = ArrayList<EventsItemMatchByName>()
                it.events?.forEach {
                    if (it.strSport.equals("Soccer")){
                        list.add(it)
                    }
                }
                rvAdapter.submitList(list)
                visibleRvView()
            }else{
                visibleNoData()
            }
        })

        dashboardViewModel.networkState.observe(this, androidx.lifecycle.Observer {
            if (it.status == Status.FAILED){
                toast("${it.msg}")
            }
            if (it.status == Status.RUNNING) visibleShimmer() else unvVisibleShimmer()

        })



    }

    private fun setupViewDetailLiga(it: LeaguesItem?) {
        it.let {
            logo_leaga.loadImage(it?.strBadge+"/preview")
            val liga = if (it?.strLeague == null)"-" else "${it?.strLeague}"
            tite_league.text = liga
            val  dessc = if (it?.strDescriptionIT == null) "-" else "${it?.strDescriptionES}"
            desc_league.text = dessc
        }
    }

    private lateinit var dashboardViewModel: DashboardViewModel

    private  val tabsAdapter: DashboardAdapter by lazy {
        DashboardAdapter(
            childFragmentManager,
            context
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setSupportActionbar()

        setupSeachView()

        //setupRvAdapter
        with(recycler_view){
            layoutManager = LinearLayoutManager(context  )
            adapter = rvAdapter
        }



        with(viewpager){
            adapter  = tabsAdapter
        }
        with(tablayout){
            setupWithViewPager(viewpager)
        }

      if (savedInstanceState == null){
            val id = (context as? MainActivity)?.id
            dashboardViewModel.getDetailLiga(id?:"4328")
        }
    }

    private fun setSupportActionbar() {
        (activity as MainActivity).setSupportActionBar(toolbar)
        toolbar.inflateMenu(R.menu.menus)
    }
    private fun setupSeachView() {
        search_view.setVoiceSearch(false)
        search_view.setEllipsize(true)
        search_view.setOnQueryTextListener(this)
        search_view.setOnSearchViewListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menus,menu)
        val item=menu .findItem(R.id.action_search)
        search_view.setMenuItem(item)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){

            R.id.action_search -> {
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            getMatchByName(it)
        }

        return true
    }



    override fun onQueryTextChange(newText: String?): Boolean {

        return true
    }


    private fun getMatchByName(keyword:String){
        dashboardViewModel.getMatchByName(keyword)
        visibleShimmer()

    }




    private fun unvVisibleShimmer() {
        container_shimmer.visibility = View.GONE
    }

    private fun visibleShimmer() {
        container_shimmer.visibility = View.VISIBLE
        unVisibeNoData()
        unVisibleRvView()
        //unVisibleFragment()
    }

    private fun visibleNoData(){
        no_data_.visibility = View.VISIBLE
        unvVisibleShimmer()
        unVisibleRvView()
        unVisibleFragment()
    }

    private fun unVisibeNoData(){
        no_data_.visibility = View.GONE
    }

    private fun visibleRvView(){
        recycler_view.visibility = View.VISIBLE
        unVisibleFragment()
        unvVisibleShimmer()
        unVisibeNoData()
    }

    private fun unVisibleRvView(){
        recycler_view.visibility = View.GONE
    }

    private fun visibleFragment(){
        unVisibleRvView()
        unVisibeNoData()
        unvVisibleShimmer()

        container_about_league.visibility = View.VISIBLE
        tablayout.visibility = View.VISIBLE
        viewpager.visibility = View.VISIBLE

    }
    private fun unVisibleFragment(){
        container_about_league.visibility = View.GONE
        tablayout.visibility = View.GONE
        viewpager.visibility = View.GONE
    }

    override fun onItemSelected(position: Int, item: EventsItemMatchByName,view: View) {
        val action = DashboardFragmentDirections.actionFragmentListMovieToDetailMovieFragment(
            EventsItem(),item)

        Navigation.findNavController(view).navigate(action)


    }




}
