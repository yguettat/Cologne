package com.example.cologne.ui

import com.example.cologne.model.RecommendedFoodDrink
import com.example.cologne.model.RecommendedGaming
import com.example.cologne.model.RecommendedLocation
import com.example.cologne.model.RecommendedServices
import com.example.cologne.model.RecommendedSport
import com.example.cologne.model.RecommendedUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecommendedViewModel {

    private val _uiState = MutableStateFlow(RecommendedUiState())
    val uiState: StateFlow<RecommendedUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(selectedCategory: String) {
        _uiState.update { currentState ->
            currentState.copy(
                currentCategory = selectedCategory
            )
        }
    }

    fun updateCurrentRecommendation(recommendedLocation: RecommendedLocation) {
        when (recommendedLocation) {
            is RecommendedFoodDrink -> _uiState.update { currentState ->
                currentState.copy(currentRecommendedFoodDrink = recommendedLocation)
            }
            is RecommendedGaming -> _uiState.update { currentState ->
                currentState.copy(currentRecommendedGaming = recommendedLocation)
            }
            // Add other types of RecommendedLocation as needed
            is RecommendedServices -> TODO()
            is RecommendedSport -> TODO()
        }
    }


    fun resetCurrentCategory() {
        _uiState.value = RecommendedUiState()
    }

    fun resetCurrentRecommendation() {
        _uiState.value = RecommendedUiState()
    }
}