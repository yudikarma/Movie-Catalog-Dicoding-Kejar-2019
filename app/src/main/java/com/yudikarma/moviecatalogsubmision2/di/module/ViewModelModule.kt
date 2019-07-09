package com.yudikarma.moviecatalogsubmision2.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yudikarma.moviecatalogsubmision2.ui.movie.ListMovieViewModel
import com.yudikarma.moviecatalogsubmision2.ui.tvshow.ListTvShowViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) :ViewModelProvider.Factory

    /*@Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    internal abstract fun bindDetailMovie(
        detailMovieViewModel: DetailMovieViewModel
    ):ViewModel*/

    @Binds
    @IntoMap
    @ViewModelKey(ListMovieViewModel::class)
    internal abstract fun bindListMovie(
        listMovieViewModel: ListMovieViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListTvShowViewModel::class)
    internal abstract fun bindListTvShow(
        listTvShowViewModel: ListTvShowViewModel
    ):ViewModel
}