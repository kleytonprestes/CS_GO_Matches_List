package com.example.csgomatcheslist.data.remote.model

data class LeagueResponse(
    val id: Int,
    val image_url: String,
    val modified_at: String,
    val name: String,
    val slug: String,
    val url: String
)