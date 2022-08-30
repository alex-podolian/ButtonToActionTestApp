package com.example.buttontoactiontestapp.core.presentation.button

import android.util.Log
import com.example.buttontoactiontestapp.core.business.usecases.DefaultFetchActionsConfigCase
import com.example.buttontoactiontestapp.core.data.api.ApiHelper
import com.example.buttontoactiontestapp.core.data.api.NetworkManager
import com.example.buttontoactiontestapp.core.data.model.ButtonAction
import com.example.buttontoactiontestapp.core.data.repository.ButtonRepository
import com.example.buttontoactiontestapp.core.presentation.BaseStore
import com.example.buttontoactiontestapp.core.presentation.EffectPublisher
import com.example.buttontoactiontestapp.core.presentation.StatePublisher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext

class ButtonStore(private val scope: CoroutineScope) :
    BaseStore<ButtonState, ButtonIntent, ButtonEffect>(scope, ButtonState()) {

    override suspend fun processIntent(
        state: ButtonState,
        intent: ButtonIntent,
        statePublisher: StatePublisher<ButtonState>,
        effectPublisher: EffectPublisher<ButtonEffect>
    ): Unit = when (intent) {
        is ButtonIntent.LoadConfiguration -> loadConfiguration(
            state,
            statePublisher,
            effectPublisher
        )
        is ButtonIntent.PerformAction -> performAction(
            state,
            intent,
            statePublisher,
            effectPublisher
        )
        is ButtonIntent.FinishRotation -> statePublisher(state.copy(isRotating = false))
    }

    private suspend fun loadConfiguration(
        state: ButtonState,
        statePublisher: StatePublisher<ButtonState>,
        effectPublisher: EffectPublisher<ButtonEffect>
    ) {
        withContext(Dispatchers.IO) {
            DefaultFetchActionsConfigCase(ButtonRepository(ApiHelper(NetworkManager.apiService)))
                .invoke()
                .onStart { statePublisher(state.copy(isLoading = true)) }
                .catch {
                    //TODO: implement no network handling
                    statePublisher(state.copy(isLoading = false))
                    it.printStackTrace()
                }
                .collect {
                    Log.d("ButtonStore", "$it")
                    statePublisher(state.copy(isLoading = false, buttonActions = it))
                }
        }
    }

    private suspend fun performAction(
        state: ButtonState,
        intent: ButtonIntent.PerformAction,
        statePublisher: StatePublisher<ButtonState>,
        effectPublisher: EffectPublisher<ButtonEffect>
    ) {
        chooseAction(intent.buttonActions)

    }

    private fun chooseAction(buttonActions: List<ButtonAction>) {
        buttonActions.filter { buttonAction -> filterActions(buttonAction) }
    }

    private fun filterActions(buttonAction: ButtonAction): Boolean {
        if (!buttonAction.enabled) {
            return false
        }
        return true
    }
}