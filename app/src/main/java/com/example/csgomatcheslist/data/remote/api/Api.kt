package com.example.csgomatcheslist.data.remote.api

import com.example.csgomatcheslist.data.remote.model.MatchResponse
import retrofit2.http.GET

interface Api {

    @GET("matches")
    suspend fun getMatches() : List<MatchResponse>
}