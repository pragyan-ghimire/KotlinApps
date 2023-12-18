package com.example.jetmovieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    val expanded = remember {
        mutableStateOf(false)
    }
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(IntrinsicSize.Min)
            .clickable {
                onItemClick(movie.id)
            },

        ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .padding(12.dp),
                shadowElevation = 4.dp,
                shape = RectangleShape

            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .build(),
                    contentDescription = "Movie poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(shape = CircleShape)
                )
//                Image(imageVector = Icons.Default.AccountBox , contentDescription = "Movie Image")
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {

                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.labelLarge
                )

                AnimatedVisibility(visible = expanded.value) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot:")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append(movie.plot)
                                }


                            },
                            modifier = Modifier.padding(5.dp)
                        )
                        Divider(modifier=Modifier.padding(3.dp))


                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = "Ratings: ${movie.rating}",
                            style = MaterialTheme.typography.labelLarge
                        )


                    }
                }

                Icon(
                    imageVector = if (expanded.value)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            expanded.value = !expanded.value

                        },

                )

            }

        }


    }
}
