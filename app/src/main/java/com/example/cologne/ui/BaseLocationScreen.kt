package com.example.cologne.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.example.cologne.model.RecommendedLocation

@Composable
fun BaseLocationDetail(
    location: RecommendedLocation,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ){

        Column(
            modifier = Modifier.padding(16.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(location.locationPic),
                contentDescription = stringResource(location.locationName),
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(256.dp)
                    .aspectRatio(1f)
                    .border(BorderStroke(2.dp, Color.Gray)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(location.locationName),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Icon(Icons.Filled.LocationOn, contentDescription = "Location Icon")
                Text(
                    text = stringResource(location.locationAddress),
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(location.locationDescription),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge

            )
        }
    }
}