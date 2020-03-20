package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.detail.detailMatch.DetailMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.detail.detailTeam.TeamDetailProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteMatch.FavoriteMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam.TeamFavoriteProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.lastMatch.ListLastMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.nextMatch.ListNextMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.match.SearchMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.team.SearchTeamProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.team.TeamProviders
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(
        modules = [ListLastMatchProviders::class,
            ListNextMatchProviders::class,
            DashboardProviders::class,
            DetailMatchProviders::class,
            TeamFavoriteProviders::class,
            SearchTeamProviders::class,
            TeamProviders::class,
            SearchMatchProviders::class,
            TeamDetailProviders::class,
            FavoriteMatchProviders::class]
    )
    abstract fun bindMainActivity(): MainActivity

}