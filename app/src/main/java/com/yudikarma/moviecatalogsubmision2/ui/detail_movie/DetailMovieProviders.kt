package com.yudikarma.moviecatalogsubmision2.ui.detail_movie

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class DetailMovieProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDetailmovieProvide(): DetailMovieFragment
}
