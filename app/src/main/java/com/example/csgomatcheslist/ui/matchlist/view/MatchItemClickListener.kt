package com.example.csgomatcheslist.ui.matchlist.view

import com.example.csgomatcheslist.data.remote.model.MatchResponse

interface MatchItemClickListener {
    fun onClick(match: MatchResponse)
}