package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.team

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchTeamProviders {
    @ContributesAndroidInjector
    internal abstract fun provideSearchTeamFragmentProvide(): SearchTeamFragment
}