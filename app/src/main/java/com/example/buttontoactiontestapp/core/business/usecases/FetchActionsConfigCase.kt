package com.example.buttontoactiontestapp.core.business.usecases

import com.example.buttontoactiontestapp.core.data.model.ButtonAction
import com.example.buttontoactiontestapp.core.data.repository.ButtonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface FetchActionsConfigCase {
    suspend operator fun invoke(): Flow<List<ButtonAction>>
}

class DefaultFetchActionsConfigCase(private val placesRepository: ButtonRepository) :
    FetchActionsConfigCase {
    override suspend fun invoke(): Flow<List<ButtonAction>> = flow {
        emit(placesRepository.fetchActionsConfig())
    }
}