package com.example.movieapp.widgets

import android.graphics.Movie
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBackIos
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.material.icons.sharp.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.*
import coil.request.ImageRequest
import com.example.movieapp.models.MovieItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty1

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun ImageSlider(
    modifier: Modifier = Modifier,
    imgUrls: List<String>
) {
    Row(
        modifier = modifier
    ) {
        val pagerState = rememberPagerState(0)
        val coroutineScope = rememberCoroutineScope()

        val constraintsSet = ConstraintSet {
            val previousArrow = createRefFor("previousArrow")
            val currentImage = createRefFor("currentImage")
            val nextArrow = createRefFor("nextArrow")

            constrain(previousArrow) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 12.dp)
                bottom.linkTo(parent.bottom)
            }

            constrain(currentImage) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }

            constrain(nextArrow) {
                top.linkTo(parent.top)
                end.linkTo(parent.end, margin = 12.dp)
                bottom.linkTo(parent.bottom)
            }
        }

        ConstraintLayout(
            constraintSet = constraintsSet,
            modifier = Modifier
                .fillMaxSize()
        ) {
            // hide previous arrow if first image is showed
            if (pagerState.currentPage > 0) {
                Icon(
                    modifier = Modifier
                        .layoutId("previousArrow")
                        .zIndex(1.0F)
                        .clickable {
                        coroutineScope.launch {
                            pagerState.scrollToPage(pagerState.currentPage - 1)
                        }
                    },
                    imageVector = Icons.Sharp.ArrowBack,
                    contentDescription = "Arrow Back",
                    tint = Color.White
                )
            }

            HorizontalPager(
                count = imgUrls.size,
                state = pagerState,
            ) { index ->
               SubcomposeAsyncImage(
                   modifier = Modifier
                       .layoutId("currentImage")
                       .fillMaxSize(),
                   model = imgUrls[index],
                   contentDescription = "Movie Image",
                   contentScale = ContentScale.FillBounds,
               )
            }

            // hide next arrow if last image is showed
            if (pagerState.currentPage < imgUrls.size - 1) {
                Icon(
                    modifier = Modifier
                        .layoutId("nextArrow")
                        .clickable {
                            coroutineScope.launch {
                                pagerState.scrollToPage(pagerState.currentPage + 1)
                            }
                        },
                    imageVector = Icons.Sharp.ArrowForward,
                    contentDescription = "Arrow Next",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    movieItem : MovieItem,
    movieProperties: Collection<KProperty1<MovieItem, *>>,
) {
    Column(
        modifier = modifier
    ) {
        for (x in movieProperties) {

            val propertyName = x.name
            val propertyValue = x.getter(movieItem) ?: continue

            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ) {
                        append("${propertyName}: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    ) {
                        append(propertyValue.toString())
                    }
                },
                modifier =  Modifier
                    .padding(4.dp)
            )
        }
    }
}