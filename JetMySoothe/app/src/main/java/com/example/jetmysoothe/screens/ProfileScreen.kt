package com.example.jetmysoothe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetmysoothe.widgets.SootheBottomNavigation


@Composable
fun ProfileScreen(navController: NavController){
    Scaffold (
        bottomBar = {
            SootheBottomNavigation(navController = navController)
        }
    ){
        Column(modifier= Modifier.padding(it)) {
            Text(text = "Profile Screen")

        }
    }
}