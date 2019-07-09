package com.yudikarma.moviecatalogsubmision2.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment :Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    internal lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        context = getContext()?: return

        setupViewModel()

    }
    abstract fun setupViewModel()

}