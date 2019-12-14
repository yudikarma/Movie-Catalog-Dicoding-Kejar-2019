package com.yudikarma.moviecatalogsubmision2.di.builder

import com.yudikarma.moviecatalogsubmision2.feature.ui.match.MainActivity
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.dashboard.DashboardProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.detailMatch.DetailMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.lastMatch.ListLastMatchProviders
import com.yudikarma.moviecatalogsubmision2.feature.ui.match.nextMatch.ListNextMatchProviders
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [ListLastMatchProviders::class,
            ListNextMatchProviders::class,
            DashboardProviders::class,
            DetailMatchProviders::class]
    )
    abstract fun bindMainActivity(): MainActivity

}