package com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.favorite.favoriteMatch

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteMatchProviders {

    @ContributesAndroidInjector
    internal abstract fun provideListMoviesProvide(): FavoriteMatchFragment
}