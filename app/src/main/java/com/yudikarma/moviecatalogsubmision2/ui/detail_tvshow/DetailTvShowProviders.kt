package com.yudikarma.moviecatalogsubmision2.ui.detail_tvshow

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailTvShowProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDetailTvshowProvide(): DetailTvShowFragment
}