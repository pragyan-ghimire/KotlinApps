package com.example.loginui.widgets

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

//@Preview
@Composable
fun SocialIconRow(modifier:Modifier=Modifier) {
    Row (
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp)
    ){
        val context= LocalContext.current
        AsyncImage(
            model = "https://cdn.pixabay.com/photo/2015/05/17/10/51/facebook-770688_640.png",
            contentDescription = "facebook icon",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .clickable {
                           val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
                    context.startActivity(urlIntent)
                },
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            model = "https://cdn.pixabay.com/photo/2015/09/14/22/59/google-plus-940316_640.png",
            contentDescription = "google icon",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .clickable {
                    val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/v3/signin/identifier?authuser=0&continue=http%3A%2F%2Fsupport.google.com%2Faccounts%2Fanswer%2F27441%3Fhl%3Den&ec=GAlAdQ&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-2029752560%3A1701535580843793&theme=glif"))
                    context.startActivity(urlIntent)
                },
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            model = "https://cdn.pixabay.com/photo/2017/03/24/07/28/twitter-2170426_640.png",
            contentDescription = "twitter icon",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .clickable {
                    val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"))
                    context.startActivity(urlIntent)
                },
            contentScale = ContentScale.Crop
        )
    }

}