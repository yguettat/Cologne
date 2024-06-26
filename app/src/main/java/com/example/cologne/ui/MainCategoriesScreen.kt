package com.example.cologne.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cologne.R
import com.example.cologne.data.LocationsToRecommend
import com.example.cologne.ui.utils.RecommendCategoryType

enum class CologneAppScreens(@StringRes val title: Int) {
    start( R.string.app_name),
    foodDrink( R.string.foodDrink),
    gaming(R.string.gaming),
    sport(R.string.sport),
    services(R.string.services),
    gamingLocationDetail(R.string.locationDetail),
    foodDrinkLocationDetail(R.string.locationDetail)

}
@Composable
fun MainCategoryScreen(
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass,
    viewModel: RecommendedViewModel = RecommendedViewModel(),
) {
    val navController = rememberNavController()
    val contentType: RecommendCategoryType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {contentType = RecommendCategoryType.LIST_ONLY}
        WindowWidthSizeClass.Medium -> {contentType = RecommendCategoryType.LIST_AND_DETAIL}
        WindowWidthSizeClass.Expanded -> {contentType = RecommendCategoryType.LIST_AND_DETAIL}
        else -> contentType =RecommendCategoryType.LIST_ONLY
    }
    Scaffold (
        topBar = { CologneAppBar(navController)}
    ) { innerPadding -> val uiState by viewModel.uiState.collectAsState()

        NavHost(navController, startDestination = CologneAppScreens.start.name) {
            composable(CologneAppScreens.start.name) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxHeight(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier.fillMaxWidth(),
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(CologneAppScreens.foodDrink.name)
                                viewModel.updateCurrentCategory(CologneAppScreens.foodDrink.name)
                                      },
                            Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)

                        ) {
                            Text(
                                stringResource(id = R.string.foodDrink),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                        Button(
                            onClick = {
                                navController.navigate(CologneAppScreens.gaming.name)
                                viewModel.updateCurrentCategory(CologneAppScreens.gaming.name)
                                      },
                            Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                stringResource(id = R.string.gaming),
                                style = MaterialTheme.typography.titleSmall)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(CologneAppScreens.sport.name)
                                viewModel.updateCurrentCategory(CologneAppScreens.sport.name)
                                      },
                            Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                stringResource(id = R.string.sport),
                                style = MaterialTheme.typography.titleSmall)
                        }
                        Button(
                            onClick = {
                                navController.navigate(CologneAppScreens.services.name)
                                viewModel.updateCurrentCategory(CologneAppScreens.services.name)
                                      },
                            Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                stringResource(id = R.string.services),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }
            composable(CologneAppScreens.foodDrink.name) {
                if (contentType == RecommendCategoryType.LIST_ONLY) {
                    FoodDrinkScreen(
                        locations = LocationsToRecommend.foodDrinkLocations,
                        onClick = {
                            viewModel.updateCurrentRecommendation(it)
                            navController.navigate(CologneAppScreens.foodDrinkLocationDetail.name)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    FoodDrinkListAndDetailScreen(
                        locations = uiState.foodDrinkList,
                        selectedLocation = uiState.currentRecommendedFoodDrink,
                        onClick = {
                            viewModel.updateCurrentRecommendation(it)
                        },
                        modifier = Modifier.padding(innerPadding)
                        )
                }
            }
            composable(CologneAppScreens.gaming.name) {
                if (contentType == RecommendCategoryType.LIST_ONLY) {
                    GamingScreen(
                        locations = LocationsToRecommend.gamingLocations,
                        onClick = {
                            viewModel.updateCurrentRecommendation(it)
                            navController.navigate(CologneAppScreens.gamingLocationDetail.name)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    GamingListAndDetailScreen(
                        locations = uiState.gamingList,
                        selectedLocation = uiState.currentRecommendedGaming,
                        onClick = {
                            viewModel.updateCurrentRecommendation(it)
                        },
                        modifier = Modifier.padding(innerPadding),
                        )
                }
            }
            composable(CologneAppScreens.sport.name) {}
            composable(CologneAppScreens.services.name) {}
            composable(CologneAppScreens.foodDrinkLocationDetail.name) {
                val selectedLocation = uiState.currentRecommendedFoodDrink
                BaseLocationDetail(
                    selectedLocation,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(CologneAppScreens.gamingLocationDetail.name) {
                val selectedLocation = uiState.currentRecommendedGaming
                BaseLocationDetail(
                    selectedLocation,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CologneAppBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    TopAppBar(
        title = {
            val currentRoute = currentBackStackEntry?.destination?.route
            val title = when (currentRoute) {
                CologneAppScreens.start.name -> stringResource(id = R.string.app_name)
                CologneAppScreens.foodDrink.name -> stringResource(id = R.string.foodDrink)
                CologneAppScreens.gaming.name -> stringResource(id = R.string.gaming)
                CologneAppScreens.sport.name -> stringResource(id = R.string.sport)
                CologneAppScreens.services.name -> stringResource(id = R.string.services)
                CologneAppScreens.gamingLocationDetail.name -> stringResource(id = R.string.locationDetail)
                CologneAppScreens.foodDrinkLocationDetail.name -> stringResource(id = R.string.locationDetail)
                else -> stringResource(id = R.string.app_name)
            }
            Text(text = title,
                style = MaterialTheme.typography.headlineMedium)
        },
        navigationIcon = {
            val currentRoute = currentBackStackEntry?.destination?.route
            if (currentRoute != CologneAppScreens.start.name) {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "backButton"
                    )
                }
            }
        },
    )
}

