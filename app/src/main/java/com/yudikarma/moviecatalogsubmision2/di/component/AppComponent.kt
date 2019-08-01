package com.yudikarma.moviecatalogsubmision2.di.component

import android.app.Application
import com.yudikarma.moviecatalogsubmision2.MovieCatalogApp
import com.yudikarma.moviecatalogsubmision2.di.builder.ActivityBuilder
import com.yudikarma.moviecatalogsubmision2.di.builder.ServiceBuilder
import com.yudikarma.moviecatalogsubmision2.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),(AppModule::class),(ActivityBuilder::class),(ServiceBuilder::class)])
interface AppComponent {

    //Ekstensiton from comppoonen builder
    @Component.Builder
        interface Builder {

            @BindsInstance
            fun application(application: Application):Builder

            fun build() : AppComponent
        }
        fun inject(app:MovieCatalogApp)

}