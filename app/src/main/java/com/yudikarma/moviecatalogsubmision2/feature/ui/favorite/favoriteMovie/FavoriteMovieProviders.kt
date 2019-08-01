package com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteMovieProviders {
    @ContributesAndroidInjector
    internal abstract fun provideFavoriteMovieProvide(): FavoriteMovieFragment
}