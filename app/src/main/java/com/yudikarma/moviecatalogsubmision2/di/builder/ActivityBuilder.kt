package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.ui.MainActivity
import com.yudikarma.moviecatalogsubmision2.ui.detail_movie.DetailMovieProviders
import com.yudikarma.moviecatalogsubmision2.ui.detail_tvshow.DetailTvShowProviders
import com.yudikarma.moviecatalogsubmision2.ui.movie.ListMovieProviders
import com.yudikarma.moviecatalogsubmision2.ui.tvshow.ListTvShowProviders
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [ListMovieProviders::class,ListTvShowProviders::class,DetailTvShowProviders::class,DetailMovieProviders::class]
    )
    abstract fun bindMainActivity():MainActivity

}