package com.yudikarma.moviecatalogsubmision2.di.module

import com.yudikarma.moviecatalogsubmision2.data.local.provider.MovieProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ProviderModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMovieProvider(): MovieProvider
}