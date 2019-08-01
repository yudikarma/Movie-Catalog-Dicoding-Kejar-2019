package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteTvShow

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteTvShowProviders {
    @ContributesAndroidInjector
    internal abstract fun provideFavoriteTvShowProvide(): FavoriteTvShowFragment
}