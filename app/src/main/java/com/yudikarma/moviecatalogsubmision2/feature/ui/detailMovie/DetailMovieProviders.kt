package com.yudikarma.moviecatalogsubmision2.feature.ui.detailMovie

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class DetailMovieProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDetailmovieProvide(): DetailMovieFragment
}
