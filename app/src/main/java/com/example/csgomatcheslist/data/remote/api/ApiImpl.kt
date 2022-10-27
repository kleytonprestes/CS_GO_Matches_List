package com.example.csgomatcheslist.data.remote.api

import javax.inject.Inject

class ApiImpl @Inject constructor(
    private val api: Api
) {
    suspend fun getMatchList() = api.getMatches()
}