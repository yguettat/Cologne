package com.example.cologne.model

import com.example.cologne.data.LocationsToRecommend

data class RecommendedUiState(
    val currentCategory: String? = null,
    val currentRecommendation: RecommendedLocation? = null,
    val isShowingListPage: Boolean = true,
    val currentRecommendedFoodDrink: RecommendedFoodDrink = LocationsToRecommend.defaultFoodDrinkLocation,
    val currentRecommendedGaming: RecommendedGaming = LocationsToRecommend.defaultGamingLocation,
    val currentRecommendedSport: RecommendedSport? = null,
    val currentRecommendedServices: RecommendedServices? = null,
    val foodDrinkList: List<RecommendedFoodDrink> = LocationsToRecommend.foodDrinkLocations,
    val gamingList: List<RecommendedGaming> = LocationsToRecommend.gamingLocations,
)
