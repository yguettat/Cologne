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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cologne.R
import com.example.cologne.data.LocationsToRecommend

enum class CologneAppScreens(@StringRes val title: Int) {
    start(title = R.string.app_name),
    foodDrink(title = R.string.foodDrink),
    gaming(R.string.gaming),
    sport(R.string.sport),
    services(R.string.services),
    locationDetail(R.string.locationDetail)
}
@Composable
fun MainCategoryScreen(
    viewModel: RecommendedViewModel = RecommendedViewModel(),
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    Scaffold (
        topBar = { CologneAppBar(navController)}
    ) { innerPadding -> val uiState by viewModel.uiState.collectAsState()

        NavHost(navController, startDestination = CologneAppScreens.start.name) {
            composable(CologneAppScreens.start.name) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier.padding(innerPadding)
                        .fillMaxHeight(),
                ) {
                    Row(
                        modifier = modifier.fillMaxWidth()
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
                        modifier = modifier.fillMaxWidth()
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
                FoodDrinkScreen(
                    locations = LocationsToRecommend.foodDrinkLocations,
                    onClick = {
                        viewModel.updateCurrentRecommendation(it)
                        navController.navigate(CologneAppScreens.locationDetail.name)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(CologneAppScreens.gaming.name) {
                GamingScreen(
                    locations = LocationsToRecommend.gamingLocations,
                    onClick = {
                        viewModel.updateCurrentRecommendation(it)
                        navController.navigate(CologneAppScreens.locationDetail.name)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
            composable(CologneAppScreens.sport.name) {}
            composable(CologneAppScreens.services.name) {}
            composable(CologneAppScreens.locationDetail.name) {
                var selectedLocation = uiState.currentRecommendation
                if (selectedLocation != null) {
                    BaseLocationDetail(
                        selectedLocation,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun ShowDetail(
    viewModel: RecommendedViewModel,

    ) {
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
                CologneAppScreens.locationDetail.name -> stringResource(id = R.string.locationDetail)
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

