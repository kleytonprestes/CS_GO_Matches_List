package com.example.csgomatcheslist.data.remote.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchResponse(
    val begin_at: String?,
    val detailed_stats: Boolean?,
    val draw: Boolean?,
    val end_at: String?,
    val forfeit: Boolean?,
    val game: List<GameResponse>?,
    val id: Int?,
    val league: LeagueResponse?,
    val league_id: Int?,
    val live: LiveResponse?,
    val match_type: String?,
    val modified_at: String?,
    val name: String?,
    val number_of_games: Int?,
    val opponents: List<OpponentResponse>,
    val original_scheduled_at: String?,
    val rescheduled: Boolean?,
    val results: List<ResultResponse>?,
    val scheduled_at: String?,
    val serie: SerieResponse?,
    val serie_id: Int?,
    val slug: String?,
    val status: String?,
    val streams_list: List<StreamsResponse>?,
    val tournament: TournamentResponse?,
    val tournament_id: Int?,
    val videogame: VideogameResponse?,
    val winner: WinnerInfoResponse?,
    val winner_id: Int?,
    val winner_type: String?,
    var isOnline: Boolean = true
): Parcelable