package com.example.sipappliaction.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WargaDataModel(
    val name: String,
    val avatar: String,
):Parcelable
