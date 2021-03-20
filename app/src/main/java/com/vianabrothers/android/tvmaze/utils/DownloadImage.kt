package com.vianabrothers.android.tvmaze.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.vianabrothers.android.tvmaze.model.Show

fun ImageView.downloadImage(show: Show) {
    Glide.with(this.context)
        .load(show.image.original)
        .into(this)
}