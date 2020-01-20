package com.yudikarma.moviecatalogsubmision2.feature.ui.match.lastMatch

import android.content.Context
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import kotlinx.coroutines.CompletableDeferred
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ListLastMatchViewModelTest {

    private val idLiga = "4346"


    private val apiHelper : ApiHelper = Mockito.mock(ApiHelper::class.java)

    private val apidatabase : AppDatabase = Mockito.mock(AppDatabase::class.java)

    private val appPredrence : AppPreferenceHelper = Mockito.mock(AppPreferenceHelper::class.java)

    private val context : Context = Mockito.mock(Context::class.java)

    private val lastMatchModel = LastMatchModel()

    private val deferredLastMatch = CompletableDeferred<Response<LastMatchModel>>()


    @Mock
    private lateinit var repository : Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Repository(apiHelper,apidatabase,appPredrence,context)
    }

    @Test
    fun getLastMatch() {
        //given
        Mockito.`when`(repository.getLastMatch(idLiga)).thenReturn( deferredLastMatch)

        //do
        val repo = repository.getLastMatch(idLiga)

        //result
        if (repo.isCompleted){
            assert(repo.getCompleted().body() == lastMatchModel)
        }
    }
}