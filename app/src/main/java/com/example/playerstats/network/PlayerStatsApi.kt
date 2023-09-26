package com.example.playerstats.network

import com.example.playerstats.TeamsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PlayerStatsApi {

    @GET("/teams?league=39&season=2023")
    @Headers("x-apisports-key: 88e28b87ca0029eb88bf70c1acc48eab")
    fun get2023PremierLeagueTeams(): Call<TeamsResponse>
}