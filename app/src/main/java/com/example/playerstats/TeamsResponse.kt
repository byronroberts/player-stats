package com.example.playerstats

data class TeamsResponse(val response: List<TeamData>)
data class TeamData(val team: Team)
data class Team(
    val id: String?,
    val name: String?,
    val code: String?,
    val country: String?,
    val founded: Int?,
    val logo: String?
)
