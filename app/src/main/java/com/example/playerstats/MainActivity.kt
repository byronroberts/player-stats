package com.example.playerstats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.playerstats.ui.compose.TeamsList
import com.example.playerstats.ui.theme.PlayerStatsTheme
import com.example.playerstats.viewmodel.PlayerStatsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: PlayerStatsViewModel by viewModels()
            val state = viewModel.state.collectAsState().value

            LaunchedEffect(Unit) {
                viewModel.init()
            }

            PlayerStatsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TeamsList(items = state.teams)
                }
            }
        }
    }
}