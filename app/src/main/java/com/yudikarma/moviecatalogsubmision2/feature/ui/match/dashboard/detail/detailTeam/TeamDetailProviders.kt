package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.detail.detailTeam

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class TeamDetailProviders {
    @ContributesAndroidInjector
    internal abstract fun provideeamDetailProvide(): TeamDetailFragment
}
