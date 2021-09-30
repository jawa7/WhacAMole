package com.example.whacamole

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ResultScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            val viewModel: MoleViewModel = hiltViewModel()
            Text(
                text = "Great! Your Score is ${viewModel.moleScore()}"
            )
        }
        Row(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { navController.navigate("hello_screen") }
            ) {
                Text(text = "Menu")
            }
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate("game_screen")
                }
            ) {
                Text(text = "Play Again")
            }
        }
    }
}