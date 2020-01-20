package com.yudikarma.moviecatalogsubmision2.feature.ui.match.nextMatch

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import kotlinx.coroutines.CompletableDeferred
import org.jetbrains.anko.doAsync
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ListNextMatchViewModelTest {
    private val idLiga = "4346"


    private val apiHelper : ApiHelper = Mockito.mock(ApiHelper::class.java)

    private val apidatabase : AppDatabase = Mockito.mock(AppDatabase::class.java)

    private val appPredrence : AppPreferenceHelper = Mockito.mock(AppPreferenceHelper::class.java)

    private val context : Context = Mockito.mock(Context::class.java)

    private val lastMatchModel = LastMatchModel()

    private val deferredLastMatch = CompletableDeferred<Response<LastMatchModel>>()

    private val data = MutableLiveData<LastMatchModel>()

    private val dataNew = MutableLiveData<LastMatchModel>()




    @Mock
    private lateinit var repository : Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Repository(apiHelper,apidatabase,appPredrence,context)


    }


    @Test
    fun getListNextMatchRepo() {
        //given
        Mockito.`when`(repository.getNextMatch(idLiga)).thenReturn( deferredLastMatch)
        if (deferredLastMatch.isCompleted){
            dataNew.value = deferredLastMatch.getCompleted().body()
        }


        //then
        val repo = repository.getNextMatch(idLiga)


        //return
        if (repo.isCompleted){
            data.value = repo.getCompleted().body()

            assert(repo.getCompleted().body() == lastMatchModel)
            //return
            assert(dataNew == data)
        }


    }






    }
