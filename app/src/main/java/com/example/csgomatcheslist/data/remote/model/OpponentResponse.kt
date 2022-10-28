package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OpponentResponse (
    val type : String?,
    val opponent: OpponentInfoResponse?,
): Parcelable