package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItemMatchByName
import com.yudikarma.moviecatalogsubmision2.data.network.model.LeaguesItem
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.match.SearchMatchRvAdapter
import com.yudikarma.moviecatalogsubmision2.utils.afterTextChangedDelayed
import com.yudikarma.moviecatalogsubmision2.utils.loadImage
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.jetbrains.anko.support.v4.toast


class DashboardFragment : BaseFragment() {


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
                // when other components finished their asynchronous tasks and marked the app as idle
                setupViewDetailLiga(it.get(0))
            }
        })


        dashboardViewModel.networkState.observe(this, androidx.lifecycle.Observer {
            if (it.status == Status.FAILED){
                toast("${it.msg}")
            }
            if (it.status == Status.RUNNING){
                //visibleShimmer()
            } else {
                //unvVisibleShimmer()

            }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menus,menu)
        val item=menu .findItem(R.id.action_search)
       // search_view.setMenuItem(item)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){

            R.id.action_search -> {
                if (viewpager.currentItem == 0 || viewpager.currentItem == 1){
                    DashboardFragmentDirections.actionActionMovieToSearchMatchFragment()
                }else{
                    DashboardFragmentDirections.actionActionMovieToSearchTeamFragment()
                }
                return true
            }
            R.id.action_favorite ->{
                DashboardFragmentDirections.actionActionMovieToContainerFavoriteFragment()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }





}
