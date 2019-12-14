package com.yudikarma.moviecatalogsubmision2.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

internal fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        /* .diskCacheStrategy(DiskCacheStrategy.RESOURCE)*/
        .into(this)
}
