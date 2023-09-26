package com.example.playerstats.network

import com.example.playerstats.TeamsResponse

class PlayerStatsRepository(private val playerStatsClient: PlayerStatsClient) {

    fun getPremierLeagueTeams(callback: (TeamsResponse) -> Unit) {
        return playerStatsClient.getPremierLeagueTeams(callback)
    }
}