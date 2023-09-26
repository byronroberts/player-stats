package com.example.playerstats.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.playerstats.Team
import com.example.playerstats.TeamData

@Composable
fun TeamsList(items: List<TeamData>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items) { teamData ->
            TeamListItem(teamData.team.name.orEmpty(), teamData.team.logo.orEmpty())
        }
    }
}