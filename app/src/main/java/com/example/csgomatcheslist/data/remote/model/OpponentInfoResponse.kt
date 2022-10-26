package com.example.csgomatcheslist.data.remote.model

data class OpponentInfoResponse(
    val acronym: String,
    val id: Int,
    val image_url: String?,
    val location: String,
    val modified_at: String,
    val name: String,
    val slug: String
)