package com.example.cologne.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cologne.data.LocationsToRecommend
import com.example.cologne.model.RecommendedLocation

@Composable
fun BaseLocationsList(
    locations: List<RecommendedLocation>,
    onClick: (RecommendedLocation) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(locations) { recommendedLocation ->
            LocationRow(
                location = recommendedLocation,
                onClick = onClick,
            )
        }
    }
}
@Composable
fun BaseLocationsAndDetail(
    locations: List<RecommendedLocation>,
    selectedLocation: RecommendedLocation,
    onClick: (RecommendedLocation) -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Row (modifier = modifier){
        LazyColumn(modifier = Modifier.weight(2f)) {
            items(locations) { recommendedLocation ->
                LocationRow(
                    location = recommendedLocation,
                    onClick = onClick,
                    isSelected = recommendedLocation == selectedLocation
                )
            }
        }
        BaseLocationDetail(
            location = selectedLocation,
            modifier = Modifier.weight(3f)
        )
    }
}

@Composable
fun LocationRow(
    location: RecommendedLocation,
    onClick: (RecommendedLocation) -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 8.dp else 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surface
        ),
        modifier = modifier
            .clickable { onClick(location) }
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(location.locationPic),
                contentDescription = stringResource(location.locationName),
                modifier = Modifier
                    .size(90.dp)
                    .aspectRatio(1f)
                    .border(BorderStroke(1.dp, Color.Gray)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = stringResource(location.locationName),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleLarge
                )
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn, // Use the location icon
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(18.dp).align(Alignment.CenterVertically)
                    )
                    Text(
                        text = stringResource(location.locationAddress),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }

}



@Preview
@Composable
fun LocationRowPreview() {
    LocationRow(location = LocationsToRecommend.defaultGamingLocation, onClick = {} )
}

@Preview
@Composable
fun LocationtotalPreview() {
    BaseLocationsList(locations = LocationsToRecommend.gamingLocations, onClick = {})
}
@Preview(device = Devices.TABLET)
@Composable
fun BaseLocationsAndDetailPreview() {
    BaseLocationsAndDetail(
        locations = LocationsToRecommend.foodDrinkLocations,
        selectedLocation = LocationsToRecommend.defaultFoodDrinkLocation,
        onClick = {},
        modifier = Modifier
    )
}