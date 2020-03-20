package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.search.match

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchMatchProviders {
    @ContributesAndroidInjector
    internal abstract fun provideSearchMatchFragmentProvide(): SearchMatchFragment
}