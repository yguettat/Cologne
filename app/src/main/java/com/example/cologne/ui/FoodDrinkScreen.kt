package com.example.cologne.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cologne.data.LocationsToRecommend
import com.example.cologne.model.RecommendedFoodDrink
import com.example.cologne.model.RecommendedLocation

@Composable
fun FoodDrinkScreen(
    locations: List<RecommendedFoodDrink>,
    onClick: (RecommendedLocation) -> Unit,
    modifier: Modifier = Modifier,
) {
    BaseLocationDetail(
        locations = locations,
        onClick = onClick,
        modifier = modifier)
}

@Preview
@Composable
fun FoodDrinkScreenPreview() {
    FoodDrinkScreen(
        locations = LocationsToRecommend.foodDrinkLocations,
        onClick = {},
        modifier = Modifier
    )
}