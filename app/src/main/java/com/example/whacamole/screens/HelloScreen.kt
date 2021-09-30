package com.example.whacamole

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.whacamole.ui.theme.WhacAMoleTheme

@Composable
fun HelloScreen(
    navController: NavController
) {

    val viewModel: MoleViewModel = hiltViewModel()
    viewModel.insertValues()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Whac A Mock Game",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp, end = 16.dp, start = 16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "A game where you must punch a mole",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 24.dp, end = 16.dp, start = 16.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(36.dp),
        ) {
            Text(
                text = "Your Score: ${viewModel.moleScore()}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 6.dp)
            )
            Button(
                onClick = { navController.navigate("game_screen") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.4f)
            ) {
                Text(
                    text = "Play!"
                )
            }
        }
    }
}

