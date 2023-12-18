package com.example.jetmysoothe.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetmysoothe.screens.HomeScreen
import com.example.jetmysoothe.screens.ProfileScreen

@Composable
fun SootheNavigation (){
val navController= rememberNavController()
    NavHost(navController = navController, startDestination = SootheScreens.HomeScreen.name){
        composable(SootheScreens.HomeScreen.name){
            HomeScreen(navController=navController)
        }
        composable(route=SootheScreens.ProfileScreen.name){
            ProfileScreen(navController=navController)
        }

    }

}