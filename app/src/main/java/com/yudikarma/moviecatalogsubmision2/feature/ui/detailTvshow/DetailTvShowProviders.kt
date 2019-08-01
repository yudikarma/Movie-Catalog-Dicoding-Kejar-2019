package com.yudikarma.moviecatalogsubmision2.feature.ui.detailTvshow

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailTvShowProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDetailTvshowProvide(): DetailTvShowFragment
}