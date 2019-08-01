package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.data.local.provider.MovieProvider
import com.yudikarma.mystackwidget.StackWidgetService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilder {
    @ContributesAndroidInjector
    abstract fun bindWidgetService():StackWidgetService


}