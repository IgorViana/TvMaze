package com.vianabrothers.android.tvmaze.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchShow(
    val score: Double,
    val show: Show
) : Parcelable