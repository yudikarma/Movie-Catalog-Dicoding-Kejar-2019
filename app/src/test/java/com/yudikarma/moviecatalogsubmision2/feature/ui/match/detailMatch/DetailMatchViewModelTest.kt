package com.yudikarma.moviecatalogsubmision2.feature.ui.match.detailMatch

import android.content.Context
import com.yudikarma.moviecatalogsubmision2.data.Repository
import com.yudikarma.moviecatalogsubmision2.data.local.database.AppDatabase
import com.yudikarma.moviecatalogsubmision2.data.network.client.ApiHelper
import com.yudikarma.moviecatalogsubmision2.data.network.model.LastMatchModel
import com.yudikarma.moviecatalogsubmision2.data.network.model.TeamDetailModel
import com.yudikarma.moviecatalogsubmision2.data.prefrence.AppPreferenceHelper
import kotlinx.coroutines.CompletableDeferred
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class DetailMatchViewModelTest {
    private val idLiga = "4346"

    private val idTeam = "133604"

    private val apiHelper : ApiHelper = Mockito.mock(ApiHelper::class.java)

    private val apidatabase : AppDatabase = Mockito.mock(AppDatabase::class.java)

    private val appPredrence : AppPreferenceHelper = Mockito.mock(AppPreferenceHelper::class.java)

    private val context : Context = Mockito.mock(Context::class.java)

    private val responseDetailMatch = LastMatchModel()
    private val deferredGetDetailMatch = CompletableDeferred<Response<LastMatchModel>>()
    private val responseGetTeamInfoHome = TeamDetailModel()
    private val deferredGetTeamInfoHome = CompletableDeferred<Response<TeamDetailModel>>()


    @Mock
    private lateinit var repository : Repository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Repository(apiHelper,apidatabase,appPredrence,context)
    }

    @Test
    fun getDetailMatch() {

        //given
        Mockito.`when`(repository.getDetailMatch(idLiga)).thenReturn( deferredGetDetailMatch)

        //do
        val repo = repository.getDetailMatch(idLiga)

        //result
        if (repo.isCompleted){
            assert(repo.getCompleted().body() == responseDetailMatch)
        }
    }

    @Test
    fun getTeamInfoHome() {
        //given
        Mockito.`when`(repository.getTeamInfo(idTeam)).thenReturn( deferredGetTeamInfoHome)

        //do
        val repo = repository.getTeamInfo(idTeam)

        //result
        if (repo.isCompleted){
            assert(repo.getCompleted().body() == responseGetTeamInfoHome)
        }
    }


}