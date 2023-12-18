package com.example.jetmysoothe.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmysoothe.model.AlignYourBodyData
import com.example.jetmysoothe.model.FavoriteCollectionsData
import com.example.jetmysoothe.model.getAlignYourBody
import com.example.jetmysoothe.model.getFavoriteCollections
import com.example.jetmysoothe.widgets.AlignYourBodyAlignment
import com.example.jetmysoothe.widgets.FavoriteCollectionCard
import com.example.jetmysoothe.widgets.SearchBar
import com.example.jetmysoothe.widgets.SootheBottomNavigation


//@Preview
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    alignYourBodyList: List<AlignYourBodyData> = getAlignYourBody()
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyList) {
            AlignYourBodyAlignment(
                picture = it.picture,
                picInfo = it.picInfo
            )
        }
    }

}


//@Preview
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionsList: List<FavoriteCollectionsData> = getFavoriteCollections()
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsList) {
            FavoriteCollectionCard(
                picture = it.picture,
                picInfo = it.picInfo
            )
        }
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}


//@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               navController: NavController) {
    Scaffold(
        bottomBar = {
            SootheBottomNavigation(navController = navController)
        }
    ) {
        Column(modifier= modifier
            .padding(it)
            .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
            HomeSection(title = "Align Your Body") {
                AlignYourBodyRow()
            }
            HomeSection(title = "Favorite Collections") {
                FavoriteCollectionsGrid()
            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    val navController= rememberNavController()
    HomeScreen(navController = navController)
}

//@Preview(showBackground = true)
//@Composable
//fun MySootheAppPortrait() {
//    JetMySootheTheme {
//        Scaffold(
//            bottomBar = {
//                SootheBottomNavigation()
//            }
//        ) { paddingValues ->
//            HomeScreen(modifier = Modifier.padding(paddingValues))
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun MySootheAppLandscape() {
//    JetMySootheTheme {
//        Surface(
//            color = MaterialTheme.colorScheme.background
//        ) {
//
//            Row {
//                SootheNavigationRail()
//                HomeScreen()
//            }
//        }
//    }
//}
//
//@Composable
//fun MySootheApp(windowSize: WindowSizeClass) {
//    when (windowSize.widthSizeClass) {
//        WindowWidthSizeClass.Compact -> {
//            MySootheAppPortrait()
//        }
//
//        WindowWidthSizeClass.Expanded -> {
//            MySootheAppLandscape()
//        }
//    }
//
//}