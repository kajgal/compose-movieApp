package com.example.movieapp.screens.home

import android.graphics.Movie
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.sharp.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.movieapp.models.MovieItem
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.screens.MoviesViewModel

@Composable
fun HomeScreen(navController: NavController, moviesViewModel: MoviesViewModel = viewModel()) {
    Scaffold(
        topBar = {
            Column() {
                TopAppBar(
                    backgroundColor = Color(0xFF545351)
                ) {
                    val constraintsSet = ConstraintSet {
                        val title = createRefFor("title")

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
                        Text(
                            modifier = Modifier
                                .layoutId("title"),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(color = Color.White)
                                ) {
                                    append("Movies")
                                }
                            },
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Divider(
                    color = MaterialTheme.colors.primary,
                    thickness = 2.dp
                )
            }
        },
    ) {
       MainContent(navController = navController, moviesViewModel)
    }
}

/*
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Column() {
                TopAppBar(
                    modifier = Modifier
                        .height(40.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    val constraintsSet = ConstraintSet {
                        val navigationIcon = createRefFor("navIcon")
                        val title = createRefFor("title")
                        val actionIcon = createRefFor("actionIcon")

                        constrain(navigationIcon) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start, margin = 8.dp)
                            bottom.linkTo(parent.bottom)
                        }

                        constrain(title) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }

                        constrain(actionIcon) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end, margin = 8.dp)
                            bottom.linkTo(parent.bottom)
                        }

                    }

                    ConstraintLayout(
                        constraintSet = constraintsSet,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Icon(
                            modifier = Modifier
                                .layoutId("navIcon")
                                .size(24.dp),
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Arrow Back"
                        )

                        Text(
                            modifier = Modifier
                                .layoutId("title"),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(color = Color.Black)
                                ) {
                                    append("GATHER")
                                }
                                withStyle(
                                    style = SpanStyle(color = MaterialTheme.colors.primary)
                                ) {
                                    append("UP")
                                }
                            }
                        )

                        Icon(
                            modifier = Modifier
                                .layoutId("actionIcon")
                                .size(24.dp),
                            imageVector = Icons.Filled.Tune,
                            contentDescription = "Settings"
                        )
                    }
                }
                Divider(
                    color = MaterialTheme.colors.primary,
                    thickness = 2.dp
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                elevation = 5.dp
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Start")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Sports,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Aktywności")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Place,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Obiekty")
                    }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Chat,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Wiadomości")
                    }
                )
            }
        }
    ) {
       // MainContent(navController = navController)
    }
}
 */

@Composable
fun MainContent(navController: NavController, moviesViewModel: MoviesViewModel = viewModel()) {

    val moviesList = moviesViewModel.getMoviesList()

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(items = moviesList) {
                MovieRow(movieItem = it) { movie ->
                    navController.navigate(
                        route = MovieScreens.DetailsScreen.name + "/${movie.imdbID}"
                    )
                }
            }
        }
    }
}

@Composable
fun MovieRow(movieItem: MovieItem, onItemClick: (MovieItem) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(
                start = 4.dp,
                end = 4.dp,
                bottom = 12.dp
            )
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movieItem)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
        backgroundColor = Color.White
    ) {
        val constraintsSet = ConstraintSet {
            val movieImage = createRefFor("movieImage")
            val movieInfo = createRefFor("movieInfo")
            val expandIcon = createRefFor("expandIcon")

            constrain(movieImage) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }

            constrain(movieInfo) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(movieImage.end, margin = 4.dp)
                end.linkTo(parent.end, margin = 4.dp)
                width = Dimension.fillToConstraints
            }

            constrain(expandIcon) {
                bottom.linkTo(parent.bottom, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
            }

        }

        ConstraintLayout(
            constraintSet = constraintsSet
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight()
                    .layoutId("movieImage"),
                model = movieItem.Images[0],
                contentDescription = "Movie Image",
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .layoutId("movieInfo"),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = movieItem.Title,
                    color = Color.Black,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
            }

            Icon(
                modifier = Modifier
                    .layoutId("expandIcon")
                    .size(16.dp),
                imageVector = Icons.Sharp.ArrowForward,
                contentDescription = "Details Icon",
                tint = Color.Black
            )
        }
    }
}
