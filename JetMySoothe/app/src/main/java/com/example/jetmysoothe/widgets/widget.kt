package com.example.jetmysoothe.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.autoSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetmysoothe.R
import com.example.jetmysoothe.navigations.SootheScreens

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    val searchText = remember {
        mutableStateOf("")
    }
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current
    TextField(
        value = searchText.value,
        onValueChange = {
            searchText.value = it
        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        enabled = true,
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        keyboardActions = KeyboardActions {
            keyboardController?.hide()
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
        ),


        )

}

//@Preview
@Composable
fun AlignYourBodyAlignment(
    modifier: Modifier = Modifier,
    picture: Int,
    picInfo: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = picture),
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop

        )
        Text(
            text = picInfo,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 14.dp, bottom = 8.dp)
        )
    }

}

//@Preview
@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    picture: Int,
    picInfo: String
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(id = picture),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = picInfo,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

//@Preview
@Composable
fun SootheBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val isSelected = remember {
        mutableStateOf(true)
    }
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = isSelected.value,
            onClick = {
                navController.navigate(route = SootheScreens.HomeScreen.name)
                isSelected.value=true
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(text = "Home")
            }
        )
        NavigationBarItem(
            selected = !isSelected.value,
            onClick = {
                navController.navigate(route = SootheScreens.ProfileScreen.name)
                isSelected.value=false
            },
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = "Profile")
            }
        )
    }
}

//@Preview
@Composable
fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(horizontal = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NavigationRailItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null)
                },
                label = {
                    Text(text = "Home")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                label = {
                    Text(text = "Profile")
                }
            )
        }
    }
}
