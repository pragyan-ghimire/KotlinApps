package com.example.jetbizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Card(
            modifier = Modifier
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CreateProfileImage()
                Divider()
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                    Log.i("Button", "Button is clicked")
                }) {
                    Text(text = "Portfolio")
                }
            }
            if (buttonClickedState.value) {
                Content()
                Log.i("Content", "portfolio shown")
            }

        }

    }
}


@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(data) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp),
                shape = RectangleShape
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CreateProfileImage(modifier = Modifier.size(100.dp))
                    Column (
                        modifier=Modifier.padding(7.dp)
                            .align(Alignment.CenterVertically)
                    ){
                        Text(
                            text = it,
                            fontWeight = FontWeight.Bold,
                            fontSize=18.sp
                        )
                        Text(text = "A great project indeed.")
                    }

                }
            }
        }

    }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp),
    ) {
        Text(
            text = "Miles P.",
            color = colorResource(id = R.color.primaryBluish),
            fontSize = 25.sp
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@themiles Compose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        border = BorderStroke(0.5.dp, Color.LightGray),
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "profile picture",
            //Todo: modify image
            modifier = Modifier.size(450.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}