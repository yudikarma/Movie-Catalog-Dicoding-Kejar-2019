package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.feature.ui.MainActivity
import com.yudikarma.moviecatalogsubmision2.feature.ui.detailMovie.DetailMovieProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.detailTvshow.DetailTvShowProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteMovie.FavoriteMovieProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.favorite.favoriteTvShow.FavoriteTvShowProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.movie.ListMovieProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.settings.SettingsProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.tvshow.ListTvShowProviders
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [ListMovieProviders::class,
            ListTvShowProviders::class,
            DetailTvShowProviders::class,
            DetailMovieProviders::class,
        FavoriteMovieProviders::class,
        FavoriteTvShowProviders::class,
        SettingsProviders::class]
    )
    abstract fun bindMainActivity():MainActivity

}