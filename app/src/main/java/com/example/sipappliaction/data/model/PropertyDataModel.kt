package com.example.sipappliaction.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PropertyDataModel(
    val tittle: String,
    val address: String,
    val owner: String
): Parcelable
