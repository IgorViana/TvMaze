package com.vianabrothers.android.tvmaze.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.vianabrothers.android.tvmaze.R

private const val loading = "https://miro.medium.com/max/875/0*H3jZONKqRuAAeHnG.jpg"
fun ImageView.downloadImage(url: String?) {
    Glide.with(this.context)
        .load(url ?: loading)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}