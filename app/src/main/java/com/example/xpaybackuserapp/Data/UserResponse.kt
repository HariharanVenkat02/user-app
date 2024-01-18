package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("users") val users: List<UserDetailsModel>,
    @SerializedName("total") val total: Int
)
