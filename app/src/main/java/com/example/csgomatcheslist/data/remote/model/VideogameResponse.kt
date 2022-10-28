package com.example.csgomatcheslist.data.remote.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideogameResponse(
    val id: Int?,
    val name: String?,
    val slug: String?
) : Parcelable