package com.example.csgomatcheslist.domain.model

import com.example.csgomatcheslist.data.remote.model.MatchResponse

interface MatchItemClickListener {
    fun onClick(match: MatchResponse?)
}