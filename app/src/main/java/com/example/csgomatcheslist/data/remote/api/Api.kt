package com.example.csgomatcheslist.data.remote.api

import com.example.csgomatcheslist.data.remote.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface Api {

    @GET("matches")
    suspend fun getMatches(
        @Header("authorization")
        token: String = "Bearer 32snOOy6FZ7nWLhfKTDiYGNlMjwbSU3yTIKzcWDjxKzA8T_VJ-M"
    ) : List<MatchResponse>
}