package com.yudikarma.moviecatalogsubmision2.di.module

import com.yudikarma.moviecatalogsubmision2.data.local.provider.MovieProvider
import com.yudikarma.moviecatalogsubmision2.feature.ui.widget.FavoriteMovieWIdget
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class WidgetsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeFavoriteMovieWidget():FavoriteMovieWIdget


}