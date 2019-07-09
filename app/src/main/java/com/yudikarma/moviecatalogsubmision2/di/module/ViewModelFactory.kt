package com.yudikarma.moviecatalogsubmision2.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creators = creators[modelClass] ?: creators.asIterable().firstOrNull(){
            modelClass.isAssignableFrom(it.key)
        }?.value ?:throw IllegalArgumentException("Unknow Viewmodel Class $modelClass") as Throwable

        return try {
            creators.get() as T
        }catch (e : Exception){
            throw RuntimeException(e)
        }
    }
}