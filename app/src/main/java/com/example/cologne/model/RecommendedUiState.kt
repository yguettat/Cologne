package com.example.cologne.model

data class RecommendedUiState(
    val currentCategory: String? = null,
    val currentRecommendation: RecommendedLocation? = null,
    val isShowingListPage: Boolean = true,
    val currentRecommendedFoodDrink: RecommendedFoodDrink? = null,
    val currentRecommendedGaming: RecommendedGaming? = null,
    val currentRecommendedSport: RecommendedSport? = null,
    val currentRecommendedServices: RecommendedServices? = null
)
