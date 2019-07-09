package com.yudikarma.moviecatalogsubmision2.ui.tvshow

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListTvShowProviders {
    @ContributesAndroidInjector
    internal abstract fun provideListTcShowProvide():ListTvShowFragment
}