package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteTeam

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TeamFavoriteProviders {

    @ContributesAndroidInjector
    internal abstract fun provideTeamFavoriteProviders(): TeamFavoriteFragment
}