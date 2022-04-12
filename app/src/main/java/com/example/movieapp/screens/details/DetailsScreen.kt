package com.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieapp.screens.MoviesViewModel
import com.example.movieapp.widgets.ImageSlider
import com.example.movieapp.widgets.MovieDetails

@Composable
fun DetailsScreen(navController: NavController, moviesViewModel: MoviesViewModel = viewModel(), movieId: String?) {

    val movieItem = moviesViewModel.getMovieById(movieId!!)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF545351)
            ) {
                val constraintsSet = ConstraintSet {
                    val arrowBack = createRefFor("iconBack")
                    val title = createRefFor("title")

                    constrain(arrowBack) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start, margin = 4.dp)
                        bottom.linkTo(parent.bottom)
                    }

                    constrain(title) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                }

                ConstraintLayout(
                    constraintSet = constraintsSet,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Icon(
                        modifier = Modifier
                            .layoutId("iconBack")
                            .clickable {
                                navController.popBackStack()
                            },
                        imageVector = Icons.Sharp.ArrowBack,
                        contentDescription = "Arrow Back",
                        tint = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .layoutId("title"),
                        text = movieItem.Title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(
                    state = rememberScrollState()
                ),
        ) {
            ImageSlider(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                imgUrls = movieItem.Images
            )
            MovieDetails(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                movieItem = movieItem,
                movieProperties = moviesViewModel.getMovieProperties()
            )
        }
    }
}
