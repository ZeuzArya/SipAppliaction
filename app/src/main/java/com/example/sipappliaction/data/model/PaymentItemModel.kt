package com.example.sipappliaction.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentItemModel (
    val name: String,
    val ammount: String
): Parcelable