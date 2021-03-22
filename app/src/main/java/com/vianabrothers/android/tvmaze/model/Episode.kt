package com.vianabrothers.android.tvmaze.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Episode(
    val id: Long,
    val name: String,
    val number: Long,
    val season: Long,
    val summary: String,
    val image: Image
) : Parcelable