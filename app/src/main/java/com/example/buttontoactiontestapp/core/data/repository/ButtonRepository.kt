package com.example.buttontoactiontestapp.core.data.repository

import com.example.buttontoactiontestapp.core.data.api.ApiHelper

class ButtonRepository(private val apiHelper: ApiHelper) {
    suspend fun fetchActionsConfig() = apiHelper.fetchActionsConfig()
}