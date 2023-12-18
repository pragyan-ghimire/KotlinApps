package com.example.jetmovieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.jetmovieapp.R
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovies
import com.example.jetmovieapp.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back arrow",
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                    navController.popBackStack()
                                })
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(text = "Movies")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) {
        Surface(
            modifier = Modifier.padding(top = 65.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRow(movie = newMovieList.first())// same as newMovieLis[0]

                // first among filter id
//            Text(text = newMovieList[0].title)

                Spacer(modifier = Modifier.height(8.dp))
                Divider(modifier = Modifier.padding(3.dp))
                Text(text = "Movie Images",
                    style=MaterialTheme.typography.displaySmall)



                HorizontalScrollableImageView(newMovieList)


            }
        }

    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
    LazyRow() {
        items(newMovieList.first().images) { image ->
            ElevatedCard(
                modifier = Modifier
                    .size(240.dp)
                    .padding(12.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = "Movie Poster",
//                                contentScale = ContentScale.Crop
                    alignment = Alignment.Center
                )
            }

        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
// Create a NavController for the preview
    val navController = rememberNavController()
    // Call DetailsScreen with sample movie data for the preview
    DetailsScreen(navController = navController, movieId = "Sample Movie Data")

}