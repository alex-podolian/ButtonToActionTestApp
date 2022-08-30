package com.example.buttontoactiontestapp.core.data.api

import com.example.buttontoactiontestapp.core.data.model.ButtonAction
import retrofit2.http.GET

interface ApiService {

    @GET("androidexam/butto_to_action_config.json")
    suspend fun fetchActionsConfig(): List<ButtonAction>
}