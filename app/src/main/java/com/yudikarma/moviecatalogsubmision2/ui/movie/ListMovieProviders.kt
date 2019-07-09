package com.yudikarma.moviecatalogsubmision2.ui.movie

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListMovieProviders {

    @ContributesAndroidInjector
    internal abstract fun provideListMoviesProvide(): FragmentListMovie
}