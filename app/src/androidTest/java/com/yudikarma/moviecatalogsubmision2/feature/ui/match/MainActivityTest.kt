package com.yudikarma.moviecatalogsubmision2.feature.ui.match


import android.view.KeyEvent
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.getIdlingResources
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.yudikarma.moviecatalogsubmision2.R
import com.yudikarma.moviecatalogsubmision2.TestApp
import com.yudikarma.moviecatalogsubmision2.utils.EspressoIdlingResource
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.junit.After
import org.junit.Rule
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import org.mockito.internal.matchers.Matches
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode





@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource);
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource);

    }


    @get:Rule val rule = ActivityTestRule(MainActivity::class.java)
    @Test
    fun test_navigationToSearch(){

        onView(isAssignableFrom(EditText::class.java)).perform(typeText("arsenal"))
        Thread.sleep(4000) //fungsi sleep digunakan untuk ngasih tau edittext untuk hit api ketika user sedang tidak mengetik
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())

        onView(isAssignableFrom(EditText::class.java)).perform(typeText("chelsea"))
        Thread.sleep(4000) //fungsi sleep digunakan untuk ngasih tau edittext untuk hit api ketika user sedang tidak mengetik
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())


        onView(isAssignableFrom(EditText::class.java)).perform(typeText("manchester"))
        Thread.sleep(4000) //fungsi sleep digunakan untuk ngasih tau edittext untuk hit api ketika user sedang tidak mengetik
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
        pressBack()



    }


}