package com.example.movieapp.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.MoviesSource
import com.example.movieapp.models.MovieItem
import com.google.gson.Gson
import kotlin.reflect.KProperty1
import kotlin.reflect.KTypeParameter
import kotlin.reflect.full.memberProperties

class MoviesViewModel : ViewModel() {

    private val moviesList = MoviesSource.getMoviesList()
    private val moviesProperties = MovieItem::class.java.kotlin.memberProperties

    fun getMoviesList(): List<MovieItem> {
        return moviesList
    }

    fun getMovieById(movieId: String): MovieItem {
        return moviesList.first { movieItem ->
            movieItem.imdbID == movieId
        }
    }

    fun getMovieProperties(): Collection<KProperty1<MovieItem, *>> {
        return moviesProperties.filter { property ->
            property.name !in listOf("Images", "Poster")
        }
    }
}