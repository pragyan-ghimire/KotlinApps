package com.example.jetmovieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetmovieapp.R
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovies
import com.example.jetmovieapp.navigations.MovieScreens
import com.example.jetmovieapp.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movies")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                ),
            )
        },

        ) {
       MainContent(navController=navController)
    }
}
@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies() ) {
    Surface(
        modifier= Modifier
            .fillMaxWidth()
            .padding(top = 65.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            LazyColumn(){
                items(items=movieList){
                    MovieRow(movie=it){movie->
                        Log.d("movieId","$movie")

                        navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    }
                }
            }
        }

    }
}
