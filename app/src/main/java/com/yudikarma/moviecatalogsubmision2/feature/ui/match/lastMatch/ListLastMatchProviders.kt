package com.yudikarma.moviecatalogsubmision2.feature.ui.match.lastMatch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListLastMatchProviders {

    @ContributesAndroidInjector
    internal abstract fun provideListMoviesProvide(): ListLastMatchFragment
}