package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class CompanyAddressModel(

    @SerializedName("address") var address: AddressDetailsModel? = AddressDetailsModel(),
    @SerializedName("department") var department: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("title") var title: String? = null


)

