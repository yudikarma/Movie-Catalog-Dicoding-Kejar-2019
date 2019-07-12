package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.ui.MainActivity
import com.yudikarma.moviecatalogsubmision2.ui.detailMovie.DetailMovieProviders
import com.yudikarma.moviecatalogsubmision2.ui.detailTvshow.DetailTvShowProviders
import com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteMovie.FavoriteMovieProviders
import com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteTvShow.FavoriteTvShowProviders
import com.yudikarma.moviecatalogsubmision2.ui.movie.ListMovieProviders
import com.yudikarma.moviecatalogsubmision2.ui.tvshow.ListTvShowProviders
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
        FavoriteTvShowProviders::class]
    )
    abstract fun bindMainActivity():MainActivity

}