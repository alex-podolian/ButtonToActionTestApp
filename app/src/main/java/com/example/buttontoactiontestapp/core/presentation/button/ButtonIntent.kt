package com.example.buttontoactiontestapp.core.presentation.button

import com.example.buttontoactiontestapp.core.data.model.ButtonAction

sealed class ButtonIntent {
    object LoadConfiguration : ButtonIntent()
    object FinishRotation : ButtonIntent()
    data class PerformAction(val buttonActions: List<ButtonAction>) : ButtonIntent()
}