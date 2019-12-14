package com.yudikarma.moviecatalogsubmision2.feature.ui.match

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.network.Status
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItem
import com.yudikarma.moviecatalogsubmision2.data.network.model.EventsItemMatchByName
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseActivity
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardFragment
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardFragmentDirections
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.SearchMatchRvAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : BaseActivity()  {

    private lateinit var viewmodel: MainViewModel

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    var id :String = ""



    companion object{
        fun getStartedIntent(context:Context,id:Int){
            context.startActivity<MainActivity>("id" to id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        id = intent.getIntExtra("id",4328).toString()

        //init nav controller
        navController = Navigation.findNavController(this,R.id.main_fragment)

    }


    override fun setupViewModel() {
        viewmodel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
    }

    fun goToDetailEvent(event:EventsItem,fragment: Fragment){
        DashboardFragment.goToDetailEvent(eventsItem = event,fragment = fragment)
    }
}
