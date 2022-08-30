package com.example.buttontoactiontestapp.core.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun fetchActionsConfig() = apiService.fetchActionsConfig()
}