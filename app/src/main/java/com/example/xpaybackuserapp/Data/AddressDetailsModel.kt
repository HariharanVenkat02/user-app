package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class AddressDetailsModel(

    @SerializedName("address")
    var address: String? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("coordinates")
    var geoCoordinates: Coordinates? = Coordinates(),
    @SerializedName("postalCode")
    var postalCode: String? = null,
    @SerializedName("state")
    var state: String? = null
)


