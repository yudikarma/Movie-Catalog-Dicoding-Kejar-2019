package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.team

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TeamProviders {
    @ContributesAndroidInjector
    internal abstract fun provideTeamProvidersProvide(): TeamFragment
}