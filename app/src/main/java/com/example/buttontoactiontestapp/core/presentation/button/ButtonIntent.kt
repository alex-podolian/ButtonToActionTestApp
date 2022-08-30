package com.example.buttontoactiontestapp.core.presentation.button

sealed class ButtonIntent {
    object LoadConfiguration : ButtonIntent()
    data class PerformAction(val action: String) : ButtonIntent()
}