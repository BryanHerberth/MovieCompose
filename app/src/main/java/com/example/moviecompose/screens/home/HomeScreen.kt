package com.example.moviecompose.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviecompose.model.Movie
import com.example.moviecompose.model.getMovies
import com.example.moviecompose.navigation.MovieScreens
import com.example.moviecompose.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Blue,
            elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
        MaiContent(navController = navController )
    }
}

@Composable
fun MaiContent(
    navController: NavController,
    moviesList : List<Movie> = getMovies()){

    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = moviesList)
            {
                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }
            }
        }
    }



}

