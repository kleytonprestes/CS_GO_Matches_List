package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultResponse(
    val score: Int?,
    val team_id: Int?
): Parcelable