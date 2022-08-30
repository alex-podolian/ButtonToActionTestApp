package com.example.buttontoactiontestapp.core.presentation.button

import com.example.buttontoactiontestapp.core.data.model.ButtonAction

data class ButtonState(
    val isLoading: Boolean = false,
    val isRotating: Boolean = false,
    val buttonActions: List<ButtonAction>? = null,
)