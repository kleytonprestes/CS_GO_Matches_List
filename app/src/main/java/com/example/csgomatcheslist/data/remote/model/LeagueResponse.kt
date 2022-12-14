package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LeagueResponse(
    val id: Int?,
    val image_url: String?,
    val modified_at: String?,
    val name: String?,
    val slug: String?,
    val url: String?
): Parcelable