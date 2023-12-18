package com.example.jetmysoothe.model

import com.example.jetmysoothe.R

data class AlignYourBodyData(
    val picture: Int,
    val picInfo: String
)
fun getAlignYourBody(): List<AlignYourBodyData>{
    return listOf(
        AlignYourBodyData(
            picture = R.drawable.ab1_inversions,
            picInfo = "Inversions"
        ),
        AlignYourBodyData(
            picture = R.drawable.ab2_quick_yoga,
            picInfo = "Quick Yoga"
        ),
        AlignYourBodyData(
            picture = R.drawable.ab3_stretching,
            picInfo = "Stretching"
        ),
        AlignYourBodyData(
            picture = R.drawable.ab4_tabata,
            picInfo = "Tabata"
        ),
        AlignYourBodyData(
            picture = R.drawable.ab5_hiit,
            picInfo = "Hiit"
        ),
        AlignYourBodyData(
            picture = R.drawable.ab6_pre_natal_yoga,
            picInfo = "Pre Natal Yoga"
        ),

    )
}