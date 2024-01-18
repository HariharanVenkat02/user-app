package com.example.xpaybackuserapp.Data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserDetailsModel(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("firstName")
    var firstName: String? = null,
    @SerializedName("lastName")
    var lastName: String? = null,
    @SerializedName("maidenName")
    var middleName: String? = null,
    @SerializedName("age")
    var age: Int? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("birthDate")
    var dob: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("bloodGroup")
    var bloodGroup: String? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("weight")
    var weight: Double? = null,
    @SerializedName("eyeColor")
    var eyeColor: String? = null,
    @SerializedName("hair")
    var hair: HairDetailsModel? = HairDetailsModel(),
    @SerializedName("domain")
    var domain: String? = null,
    @SerializedName("ip")
    var ip: String? = null,
    @SerializedName("address")
    var address: AddressDetailsModel? = AddressDetailsModel(),
    @SerializedName("macAddress")
    var macAddress: String? = null,
    @SerializedName("university")
    var university: String? = null,
    @SerializedName("bank")
    var bank: BankDetailsModel? = BankDetailsModel(),
    @SerializedName("company")
    var company: CompanyDetailsModel? = CompanyDetailsModel(),
    @SerializedName("ein")
    var ein: String? = null,
    @SerializedName("ssn")
    var ssn: String? = null,
    @SerializedName("userAgent")
    var userAgent: String? = null,
    @SerializedName("crypto")
    var crypto: CryptoDetailsModel? = CryptoDetailsModel()
) : Serializable
