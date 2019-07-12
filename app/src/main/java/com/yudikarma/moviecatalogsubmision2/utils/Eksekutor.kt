package com.yudikarma.moviecatalogsubmision2.utils

import java.util.concurrent.Executors


private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
private val NETWORK_EXECUTOR = Executors.newFixedThreadPool(5)

fun ioThread(f : () -> Unit){
        IO_EXECUTOR.execute(f)
}