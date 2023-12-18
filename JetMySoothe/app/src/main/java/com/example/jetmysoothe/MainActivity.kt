package com.example.jetmysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetmysoothe.navigations.SootheNavigation
import com.example.jetmysoothe.screens.HomeScreen
import com.example.jetmysoothe.ui.theme.JetMySootheTheme

//import com.example.jetmysoothe.screens.MySootheApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetMySootheTheme {

//            val windowSizeClass = calculateWindowSizeClass(activity = this)
//            MySootheApp(windowSize = windowSizeClass)
                SootheNavigation()
            }

        }
    }
}
@Preview
@Composable
fun MyApp(){
    JetMySootheTheme {

//            val windowSizeClass = calculateWindowSizeClass(activity = this)
//            MySootheApp(windowSize = windowSizeClass)
        SootheNavigation()
    }

}
