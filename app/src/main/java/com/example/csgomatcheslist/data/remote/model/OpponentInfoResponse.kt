package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OpponentInfoResponse(
    val id: Int?,
    val image_url: String?,
    val location: String?,
    val modified_at: String?,
    val name: String?,
    val slug: String?
) : Parcelable