package com.example.movieapp.navigation

import java.lang.IllegalArgumentException

enum class MovieScreens {
    SplashScreen,
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens
            = when (route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Invalid route")
            }
    }
}