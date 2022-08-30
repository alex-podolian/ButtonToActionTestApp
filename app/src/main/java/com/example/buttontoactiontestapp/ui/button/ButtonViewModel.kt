package com.example.buttontoactiontestapp.ui.button

import androidx.lifecycle.viewModelScope
import com.example.buttontoactiontestapp.core.presentation.BaseStore
import com.example.buttontoactiontestapp.core.presentation.button.ButtonEffect
import com.example.buttontoactiontestapp.core.presentation.button.ButtonIntent
import com.example.buttontoactiontestapp.core.presentation.button.ButtonState
import com.example.buttontoactiontestapp.core.presentation.button.ButtonStore
import com.example.buttontoactiontestapp.ui.BaseViewModel

class ButtonViewModel : BaseViewModel<ButtonState, ButtonIntent, ButtonEffect>() {

    override val store: BaseStore<ButtonState, ButtonIntent, ButtonEffect> =
        ButtonStore(viewModelScope)

    init {
        dispatch(ButtonIntent.LoadConfiguration)
    }
}