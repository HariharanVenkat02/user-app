package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class BankDetailsModel(
    @SerializedName("cardExpire")
    var cardExpire: String? = null,
    @SerializedName("cardNumber")
    var cardNumber: String? = null,
    @SerializedName("cardType")
    var cardType: String? = null,
    @SerializedName("currency")
    var currency: String? = null,
    @SerializedName("iban")
    var iban: String? = null
)

