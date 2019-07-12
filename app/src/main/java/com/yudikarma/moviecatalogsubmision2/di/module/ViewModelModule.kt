package com.yudikarma.moviecatalogsubmision2.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yudikarma.moviecatalogsubmision2.ui.detailMovie.DetailMovieViewModel
import com.yudikarma.moviecatalogsubmision2.ui.detailTvshow.DetailTvShowViewModel
import com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteMovie.FavoriteMovieViewModel
import com.yudikarma.moviecatalogsubmision2.ui.favorite.favoriteTvShow.FavoriteTvShowViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    internal abstract fun bindDetailMovie(
        detailMovieViewModel: DetailMovieViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTvShowViewModel::class)
    internal abstract fun bindDetailTvShow(
        detailTvShowViewModel: DetailTvShowViewModel
    ):ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FavoriteMovieViewModel::class)
    internal abstract fun bindLFavoriteMovie(
        favoriteMovieViewModel: FavoriteMovieViewModel
    ):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteTvShowViewModel::class)
    internal abstract fun bindFavoriteTvShow(
        favoriteTvShowViewModel: FavoriteTvShowViewModel
    ):ViewModel
}