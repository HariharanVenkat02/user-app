package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat") var latitude: Double? = null,
    @SerializedName("lng") var longitude: Double? = null
)
