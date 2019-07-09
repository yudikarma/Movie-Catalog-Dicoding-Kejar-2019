package com.yudikarma.moviecatalogsubmision2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set toolbar
        setSupportActionBar(toolbar)

        //init nav controller
        navController = Navigation.findNavController(this,R.id.main_fragment)
        NavigationUI.setupWithNavController(bottom_nav,navController)
        NavigationUI.setupActionBarWithNavController(this,navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_settings -> {
                goToSettingLanguage()
                return true
            }else -> {
            return super.onOptionsItemSelected(item)
        }
        }
    }

    private fun goToSettingLanguage() {
        val intent = Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(intent)
    }

}
