package com.yudikarma.moviecatalogsubmision2.feature.ui.match.detailMatch

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class DetailMatchProviders {
    @ContributesAndroidInjector
    internal abstract fun provideDetailmovieProvide(): DetailMatchFragment
}
