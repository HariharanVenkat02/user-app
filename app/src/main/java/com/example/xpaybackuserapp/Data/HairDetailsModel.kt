package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class HairDetailsModel(
    @SerializedName("color")
    var color: String? = null,
    @SerializedName("type")
    var type: String? = null
)
