package com.example.loginui.screen

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.loginui.component.CustomTextFiled
import com.example.loginui.widgets.SocialIconRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen() {

    val context = LocalContext.current
    val visibility = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Login")
            })
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(paddingValues = it)
                .fillMaxSize()
        ) {
            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://img.freepik.com/free-vector/group-people-chatting-each-other-using-phone_74855-10709.jpg?size=626&ext=jpg")
                        .crossfade(true)
                        .build(),
                    contentDescription = "Login Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                CustomTextFiled(
                    modifier = Modifier,
                    text = "Phone Number",
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
                Button(onClick = { /*TODO*/ },
                    modifier=Modifier.width(120.dp)) {
                    Text(text = "Login")
                }



                Text(
                    text = "OR login with",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription ="down arrow",
                    modifier=Modifier.clickable{
                        visibility.value=!visibility.value
                    })
                AnimatedVisibility(visible = visibility.value) {
                    Column (
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        SocialIconRow()
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Don't have a account?",
                                style = TextStyle(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                            TextButton(onClick = {}) {

                                Text(
                                    text = "Sign up",
                                    style = TextStyle(
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }


                        }
                    }
                }


            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun LogInScreenPreview() {
    LogInScreen()

}