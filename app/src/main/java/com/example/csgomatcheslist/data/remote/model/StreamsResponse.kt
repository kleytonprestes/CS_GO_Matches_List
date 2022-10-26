package com.example.csgomatcheslist.data.remote.model

data class StreamsResponse(
    val embed_url: String,
    val language: String,
    val main: Boolean,
    val official: Boolean,
    val raw_url: String
)