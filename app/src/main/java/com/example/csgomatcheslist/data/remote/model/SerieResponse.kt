package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SerieResponse(
    var begin_at: String?,
    var end_at: String?,
    var full_name: String?,
    var id: Int?,
    var league_id: Int?,
    var modified_at: String?,
    var name: String?,
    var season: String?,
    var slug: String?,
    var winner_id: Int?,
    var winner_type: String?,
    var year: Int?
): Parcelable