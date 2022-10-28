package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResponse(
    val begin_at: String?,
    val complete: Boolean?,
    val detailed_stats: Boolean?,
    val end_at: String?,
    val finished: Boolean?,
    val forfeit: Boolean?,
    val id: Int?,
    val length: Int?,
    val match_id: Int?,
    val position: Int?,
    val status: String?,
    val winnerResponse: WinnerResponse?,
    val winner_type: String?
): Parcelable