package com.yudikarma.moviecatalogsubmision2.feature.ui.settings


import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton

import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import com.yudikarma.moviecatalogsubmision2.feature.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SettingsFragment : Fragment(), CompoundButton.OnCheckedChangeListener {

    @Inject
    lateinit var repository: Repository

    private lateinit var mView :View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_settings, container, false)

        setupShowSwitchStatus()
        mView?.switchMaterial_release_reminder.setOnCheckedChangeListener(this)
        mView?.switchMaterial_daily_reminder.setOnCheckedChangeListener(this)

        mView?.settinglanguage.setOnClickListener {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }


        return mView
    }

    private fun setupShowSwitchStatus() {
        if (repository.getBoolean(AppPreferenceHelper.PREF_UPCOMING_REMINDE)) mView?.switchMaterial_release_reminder.isChecked = true else mView?.switchMaterial_release_reminder.isChecked = false
        if (repository.getBoolean(AppPreferenceHelper.PREF_DAILY_REMINDER)) mView?.switchMaterial_daily_reminder.isChecked = true else mView?.switchMaterial_daily_reminder.isChecked = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.switchMaterial_daily_reminder -> setupStateDailyReminder(isChecked)
            else -> {
                setupStateReleasereminder(isChecked)

            }
        }
    }

    private fun setupStateReleasereminder(boolean: Boolean) {

        repository.setBoolean(AppPreferenceHelper.PREF_UPCOMING_REMINDE,boolean)

    }

    private fun setupStateDailyReminder(boolean: Boolean) {
        repository.setBoolean(AppPreferenceHelper.PREF_DAILY_REMINDER,boolean)
    }


}
