package com.example.xpaybackuserapp.Repositary
import com.example.xpaybackuserapp.Network.ApiService
import com.example.xpaybackuserapp.Network.SafeApiRequest

class UserRepositary(private val apiService: ApiService) : SafeApiRequest() {


    suspend fun getUserDetails(userId: Int) = apiRequest { apiService.getIndividualUser(userId) }


    suspend fun getUsersList(limit: Int, skip: Int) =
        apiRequest { apiService.getUserList(limit, skip) }
}