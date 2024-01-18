package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class CryptoDetailsModel(
    @SerializedName("coin") var coin: String? = null,
    @SerializedName("wallet") var wallet: String? = null,
    @SerializedName("network") var network: String? = null

)

