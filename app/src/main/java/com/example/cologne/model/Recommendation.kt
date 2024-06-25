package com.example.cologne.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Data model for the recommended place
 */

sealed class RecommendedLocation(
    @StringRes open val locationName: Int,
    @StringRes open val locationAddress: Int,
    @DrawableRes open val locationPic: Int,
    @StringRes open val locationDescription: Int,
)

data class RecommendedFoodDrink(
    @StringRes override val locationName: Int,
    @StringRes override val locationAddress: Int,
    @DrawableRes override val locationPic: Int,
    @StringRes override val locationDescription: Int,
) : RecommendedLocation(locationName,locationAddress,locationPic,locationDescription)

data class RecommendedGaming(
    @StringRes override val locationName: Int,
    @StringRes override val locationAddress: Int,
    @DrawableRes override val locationPic: Int,
    @StringRes override val locationDescription: Int,
) : RecommendedLocation(locationName,locationAddress,locationPic,locationDescription)

data class RecommendedServices(
    @StringRes override val locationName: Int,
    @StringRes override val locationAddress: Int,
    @DrawableRes override val locationPic: Int,
    @StringRes override val locationDescription: Int,
) : RecommendedLocation(locationName,locationAddress,locationPic,locationDescription)

data class RecommendedSport(
    @StringRes override val locationName: Int,
    @StringRes override val locationAddress: Int,
    @DrawableRes override val locationPic: Int,
    @StringRes override val locationDescription: Int,
) : RecommendedLocation(locationName,locationAddress,locationPic,locationDescription)
