package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.MoviesViewModel
import com.example.movieapp.screens.details.DetailsScreen
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.splash.SplashScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    val moviesViewModel: MoviesViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.SplashScreen.name
    ) {

        composable(MovieScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        
        composable(MovieScreens.HomeScreen.name) {
             // here we pass where where this should lead from 
            HomeScreen(
                navController = navController,
                moviesViewModel = moviesViewModel
            )
        }

        composable(
            route = MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})
        ) { backStackEntry ->

            DetailsScreen(
                navController = navController,
                moviesViewModel = moviesViewModel,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}