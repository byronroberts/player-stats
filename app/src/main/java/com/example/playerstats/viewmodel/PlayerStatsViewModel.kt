package com.example.playerstats.viewmodel

import androidx.lifecycle.ViewModel
import com.example.playerstats.TeamData
import com.example.playerstats.network.PlayerStatsClient
import com.example.playerstats.network.PlayerStatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlayerStatsViewModel(
    private val repository: PlayerStatsRepository = PlayerStatsRepository(
        PlayerStatsClient()
    )
) : ViewModel() {
    private val _state = MutableStateFlow(PlayerStatsState(arrayListOf()))
    val state: StateFlow<PlayerStatsState> = _state.asStateFlow()

    fun init() {
        repository.getPremierLeagueTeams { teamsResponse ->
            _state.value = _state.value.copy(teams = teamsResponse.response)
        }
    }
}

data class PlayerStatsState(val teams: List<TeamData>)
