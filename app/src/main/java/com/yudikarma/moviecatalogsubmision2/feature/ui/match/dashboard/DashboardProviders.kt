package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDashboardProvide(): DashboardFragment
}