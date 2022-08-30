package com.example.buttontoactiontestapp.core.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ButtonAction(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("enabled")
    val enabled: Boolean? = null,
    @SerializedName("priority")
    val priority: Int? = null,
    @SerializedName("valid_days")
    val validDays: ArrayList<Int>? = null,
    @SerializedName("cool_down")
    val coolDown: Double? = null,
) : Serializable