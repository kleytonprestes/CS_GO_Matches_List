package com.example.csgomatcheslist.data.remote.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LiveResponse(
    val opens_at: String?,
    val supported: Boolean?,
    val url: String?
):Parcelable