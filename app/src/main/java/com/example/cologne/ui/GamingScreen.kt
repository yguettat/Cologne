package com.example.cologne.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cologne.data.LocationsToRecommend
import com.example.cologne.model.RecommendedGaming
import com.example.cologne.model.RecommendedLocation

@Composable
fun GamingScreen(
    locations: List<RecommendedGaming>,
    onClick: (RecommendedLocation) -> Unit,
    modifier: Modifier = Modifier,
) {
    BaseLocationsList(
        locations = locations,
        onClick = onClick,
        modifier = modifier)
}

@Composable
fun GamingListAndDetailScreen(
    locations: List<RecommendedGaming>,
    selectedLocation: RecommendedLocation,
    onClick: (RecommendedLocation) -> Unit,
    modifier: Modifier = Modifier,
) {
    BaseLocationsAndDetail(
        locations = locations,
        selectedLocation = selectedLocation,
        onClick = onClick,
        modifier = modifier
    )
}
@Preview
@Composable
fun GamingScreenPreview() {
    GamingScreen(
        locations = LocationsToRecommend.gamingLocations,
        onClick = {},
        modifier = Modifier
    )
}