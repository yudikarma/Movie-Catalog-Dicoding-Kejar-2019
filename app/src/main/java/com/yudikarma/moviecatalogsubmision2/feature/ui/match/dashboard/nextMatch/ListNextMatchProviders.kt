package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.nextMatch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListNextMatchProviders {
    @ContributesAndroidInjector
    internal abstract fun provideListTcShowProvide(): ListNextMatchFragment
}