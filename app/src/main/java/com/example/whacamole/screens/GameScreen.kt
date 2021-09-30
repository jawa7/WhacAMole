package com.example.whacamole

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameScreen(
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        val viewModel: MoleViewModel = hiltViewModel()

        var random by remember { mutableStateOf(0) }

        val array = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        var punch by remember { mutableStateOf(0) }

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            random = array.random()
        }
        handler.postDelayed(runnable, 1000)

        Log.d("MainActivity", "GameRandom: $punch")

        Row() {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 1) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 2) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 3) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
        }

        Row() {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 4) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 5) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 6) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
        }
        Row() {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 7) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 8) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(58.dp)
            ) {
                if (random == 9) {
                    Mock(condition = true, modifier = Modifier.clickable { punch++ })
                } else {
                    FakeMoke()
                }
                Field()
            }
        }
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                viewModel.updateMole(punch)
                navController.navigate("result_screen")
            }
        ) {
            Text(
                "Save Score"
            )
        }
    }
}


@Composable
fun Field() {
    val color = if (isSystemInDarkTheme()) {
        Color.DarkGray
    } else {
        Color.Black
    }
    Canvas(
        modifier = Modifier
            .size(width = 104.dp, height = 8.dp)
    ) {
        drawRect(
            color = color,
            size = size
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Mock(
    condition: Boolean,
    modifier: Modifier
) {
    AnimatedVisibility(visible = condition) {
        Canvas(
            modifier = modifier
                .size(width = 100.dp, height = 50.dp)

        ) {
            drawArc(
                color = Color.Gray,
                startAngle = 0f,
                sweepAngle = -180f,
                useCenter = true,
                size = size.copy(width = 270F, height = 300F),
            )
            drawCircle(
                color = Color.Black,
                center = Offset(105f, 50f),
                radius = 15f
            )
            drawCircle(
                color = Color.Black,
                center = Offset(165f, 50f),
                radius = 15f
            )
            drawOval(
                color = Color.LightGray,
                topLeft = Offset(110f, 85f),
                size = size.div(5f)
            )
        }
    }
}

@Composable
fun FakeMoke(
) {

    val color = if (isSystemInDarkTheme()) {
        Color.Transparent
    } else {
        Color.White
    }
    Canvas(
        modifier = Modifier
            .size(width = 100.dp, height = 50.dp)

    ) {

        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = size.copy(width = 270F, height = 300F),
        )
    }
}