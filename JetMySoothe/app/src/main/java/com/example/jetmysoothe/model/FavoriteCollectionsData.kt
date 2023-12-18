package com.example.jetmysoothe.model

import com.example.jetmysoothe.R

data class FavoriteCollectionsData(
    val picture: Int,
    val picInfo: String
)
fun getFavoriteCollections(): List<FavoriteCollectionsData>{
    return listOf(
        FavoriteCollectionsData(
            picture = R.drawable.fc1_short_mantras,
            picInfo = "Short Mantras"
        ),
        FavoriteCollectionsData(
            picture = R.drawable.fc2_nature_meditations,
            picInfo = "Nature Meditation"
        ),
        FavoriteCollectionsData(
            picture = R.drawable.fc3_stress_and_anxiety,
            picInfo = "Stress and anxiety"
        ),
        FavoriteCollectionsData(
            picture = R.drawable.fc4_self_massage,
            picInfo = "Self Massage"
        ),
        FavoriteCollectionsData(
            picture = R.drawable.fc5_overwhelmed,
            picInfo = "Overwhelmed"
        ),
        FavoriteCollectionsData(
            picture = R.drawable.fc6_nightly_wind_down,
            picInfo = "Nightly Wind Down"
        ),

    )
}
