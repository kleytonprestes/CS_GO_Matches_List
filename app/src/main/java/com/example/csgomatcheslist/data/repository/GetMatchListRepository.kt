package com.example.csgomatcheslist.data.repository

import com.example.csgomatcheslist.data.remote.api.ApiImpl
import com.example.csgomatcheslist.data.remote.model.MatchResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class GetMatchListRepository @Inject constructor(
    private val api: ApiImpl
) {
   suspend fun getMatchList(): List<MatchResponse> {
        return api.getMatchList()
    }
}