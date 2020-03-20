package com.yudikarma.moviecatalogsubmision2.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.detail.detailMatch.DetailMatchViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.detail.detailTeam.TeamDetailViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteMatch.FavoriteMatchViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam.TeamFavoriteViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.lastMatch.ListLastMatchViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.nextMatch.ListNextMatchViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.match.SearchMatchViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.team.SearchTeamViewModel
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.team.TeamViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) :ViewModelProvider.Factory

    /*@Binds
    @IntoMap
    @ViewModelKey(DetailMatchViewModel::class)
    internal abstract fun bindDetailMovie(
        detailMovieViewModel: DetailMatchViewModel
    ):ViewModel*/

    @Binds
    @IntoMap
    @ViewModelKey(ListLastMatchViewModel::class)
    internal abstract fun bindListMovie(
        listLastMatchViewModel: ListLastMatchViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListNextMatchViewModel::class)
    internal abstract fun bindListTvShow(
        listNextMatchViewModel: ListNextMatchViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMatchViewModel::class)
    internal abstract fun bindDetailMovie(
        detailMatchViewModel: DetailMatchViewModel
    ):ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainActivity(
        mainViewModel: MainViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    internal abstract fun bindDashboardViewModel(
        dashboardViewModel: DashboardViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteMatchViewModel::class)
    internal abstract fun bindFavoriteViewModel(
        favoriteMatchViewModel: FavoriteMatchViewModel
    ):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TeamFavoriteViewModel::class)
    internal abstract fun bindFavoriteTeamViewModel(
        teamFavoriteViewModel: TeamFavoriteViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchTeamViewModel::class)
    internal abstract fun bindSearchTeamViewModel(
       searchTeamViewModel: SearchTeamViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel::class)
    internal abstract fun bindTeamTeamViewModel(
       teamViewModel: TeamViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchMatchViewModel::class)
    internal abstract fun bindSearchMatchViewModel(
       searchMatchViewModel: SearchMatchViewModel
    ):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TeamDetailViewModel::class)
    internal abstract fun bindTeamDetailViewModel(
       teamDetailViewModel: TeamDetailViewModel
    ):ViewModel
}