package com.example.playerstats.network

import com.example.playerstats.TeamsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PlayerStatsClient {

    private val BASE_URL = "https://v3.football.api-sports.io"

    val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PlayerStatsApi::class.java)

    fun getPremierLeagueTeams(callback: (TeamsResponse) -> Unit) {
        var result: TeamsResponse? = null
        client.get2023PremierLeagueTeams().enqueue(object : Callback<TeamsResponse> {
            override fun onResponse(call: Call<TeamsResponse>, response: Response<TeamsResponse>) {
                val body = response.body()
                if (body != null) {
                    callback.invoke(body)
                }
            }

            override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {

            }

        })
    }
}