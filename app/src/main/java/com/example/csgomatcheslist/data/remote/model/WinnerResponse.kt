package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WinnerResponse(
    val id: Int?,
    val type: String?
) : Parcelable