package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.LigaDetailModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.ListMatchByName
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.design.indefiniteSnackbar
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

class DashboardViewModelTest {

    private val idLiga = "4346"

    private val keyword = "Arsenal_vs_Chelsea"

    private  val ligaDetailModel = LigaDetailModel()

    private val listMatchByName = ListMatchByName()

    private val deferredGetDetailLiga = CompletableDeferred<Response<LigaDetailModel>>()

    private val deferredGetMatchByName = CompletableDeferred<Response<ListMatchByName>>()



    private val apiHelper : ApiHelper = mock(ApiHelper::class.java)

    private val apidatabase : AppDatabase = mock(AppDatabase::class.java)

    private val appPredrence : AppPreferenceHelper = mock(AppPreferenceHelper::class.java)

    private val context : Context = mock(Context::class.java)
    private val data = MutableLiveData<LigaDetailModel>()
    private val dataNew =  MutableLiveData<LigaDetailModel>()




    @Mock
    private lateinit var repository : Repository



    @Before fun setup(){
        MockitoAnnotations.initMocks(this)
        repository = Repository(apiHelper,apidatabase,appPredrence,context)


    }

    @Test
    fun getDetailLiga() = runBlocking {

        //given
        Mockito.`when`(repository.getDetailLifa(idLiga)).thenReturn( deferredGetDetailLiga)
        if (deferredGetDetailLiga.isCompleted){
            Mockito.`when`(repository.getDetailLifa(idLiga).getCompleted().body()).thenReturn(data.value )

        }


        //do
        val repo = repository.getDetailLifa(idLiga)

        //result
        if (repo.isCompleted){
            data.value = repo.getCompleted().body()

            assert(repo.getCompleted().body() == ligaDetailModel)
            assert(data == dataNew)

        }

    }

    @Test
    fun getMatchByName() {
        //given
        Mockito.`when`(repository.getMatchByName(keyword)).thenReturn( deferredGetMatchByName)

        //do
        val repo = repository.getMatchByName(keyword)

        //result
        if (repo.isCompleted){
            assert(repo.getCompleted().body() == listMatchByName)
        }
    }
}