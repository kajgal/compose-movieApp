package com.example.movieapp.screens.splash

import android.graphics.Movie
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.sharp.LiveTv
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF545351)
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController) {

    val scale = remember {
        Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(9.0f).getInterpolation(it)
                }
            )
        )
        delay(2000L)
        navController.navigate(MovieScreens.HomeScreen.name) {
            popUpTo(MovieScreens.SplashScreen.name) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(160.dp)
                .scale(scale.value),
            shape = CircleShape,
            backgroundColor = Color.Black,
            elevation = 5.dp,

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(64.dp),
                    imageVector = Icons.Sharp.LiveTv,
                    contentDescription = "Movie Icon",
                    tint = Color.White
                )
                Text(
                    text = "Movies App",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}