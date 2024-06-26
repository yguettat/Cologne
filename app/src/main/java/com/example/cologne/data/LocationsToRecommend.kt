package com.example.cologne.data

import com.example.cologne.R
import com.example.cologne.model.RecommendedFoodDrink
import com.example.cologne.model.RecommendedGaming

object LocationsToRecommend {

    val foodDrinkLocations = listOf(
            RecommendedFoodDrink(
                locationName = R.string.chinese,
                locationAddress = R.string.chineseAddress,
                locationPic = R.drawable.china_express,
                locationDescription = R.string.chineseDescription
            ),
        RecommendedFoodDrink(
                locationName = R.string.italian,
                locationAddress = R.string.italianAddress,
                locationPic = R.drawable.trattoria_palermo_da_salvatore,
            locationDescription = R.string.italianDescription
            ),
        RecommendedFoodDrink(
                locationName = R.string.gelato,
                locationAddress = R.string.gelatoAddress,
                locationPic =R.drawable.gelateria_cafeteria_south,
            locationDescription = R.string.gelatoDescription
            ),
        RecommendedFoodDrink(
                locationName = R.string.burger,
                locationAddress = R.string.burgerAddress,
                locationPic = R.drawable.die_fette_kuh,
            locationDescription = R.string.burgerDescription

            ),
    )
    val defaultFoodDrinkLocation = foodDrinkLocations[0]

    val gamingLocations = listOf (
        RecommendedGaming(
        locationName = R.string.bordgames1,
        locationAddress = R.string.boardgameAddress1,
        locationPic = R.drawable.hiveworld,
            locationDescription = R.string.boargameDescription1
        ),
        RecommendedGaming(
            locationName = R.string.boardgames2,
            locationAddress = R.string.boardgameAddress2,
            locationPic = R.drawable.brave_new_world,
            locationDescription = R.string.boardgameDescription2
        ),
        RecommendedGaming(
            locationName = R.string.retro,
            locationAddress = R.string.retroAddress,
            locationPic = R.drawable.retrospiel,
            locationDescription = R.string.retroDescripton
        ),
        )
    val defaultGamingLocation = gamingLocations[0]


}