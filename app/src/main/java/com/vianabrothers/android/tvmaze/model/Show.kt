package com.vianabrothers.android.tvmaze.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Show(
    val id: Long,
    val name: String,
    val image: Image,
    val schedule: Schedule,
    val genres: List<String>,
    val summary: String
):Parcelable