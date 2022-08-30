package com.example.buttontoactiontestapp.core.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ButtonAction(
    @SerializedName("type")
    val type: String,
    @SerializedName("enabled")
    val enabled: Boolean,
    @SerializedName("priority")
    val priority: Int,
    @SerializedName("valid_days")
    val validDays: ArrayList<Int>,
    @SerializedName("cool_down")
    val coolDown: Double,
) : Serializable