package com.example.csgomatcheslist.data.remote.model

data class GameResponse(
    val begin_at: Any,
    val complete: Boolean,
    val detailed_stats: Boolean,
    val end_at: Any,
    val finished: Boolean,
    val forfeit: Boolean,
    val id: Int,
    val length: Any,
    val match_id: Int,
    val position: Int,
    val status: String,
    val winnerResponse: WinnerResponse,
    val winner_type: String
)