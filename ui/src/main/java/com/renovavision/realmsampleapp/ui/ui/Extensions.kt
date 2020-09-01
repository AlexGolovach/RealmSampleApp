package com.renovavision.realmsampleapp.ui.ui

import androidx.appcompat.widget.AppCompatImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.LoadRequest

fun AppCompatImageView.loadSvg(url: String) {
    val imageLoader = ImageLoader.Builder(context)
        .componentRegistry {
            add(SvgDecoder(context))
        }
        .build()
    val request = LoadRequest.Builder(context)
        .data(url)
        .target(this)
        .build()
    imageLoader.execute(request)
}