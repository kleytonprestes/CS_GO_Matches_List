package com.example.csgomatcheslist.data.remote.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StreamsResponse(
    val embed_url: String?,
    val language: String?,
    val main: Boolean?,
    val official: Boolean?,
    val raw_url: String?
) : Parcelable