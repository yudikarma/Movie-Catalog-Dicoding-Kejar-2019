package com.yudikarma.moviecatalogsubmision2.feature.ui.settings

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SettingsProviders {
    @ContributesAndroidInjector
    internal abstract fun provideSettingsProvide(): SettingsFragment
}