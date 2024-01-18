package com.example.xpaybackuserapp.Network

import com.example.xpaybackuserapp.Data.UserDetailsModel
import com.example.xpaybackuserapp.Data.UserResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUserList(
        @Query("limit") limit: Int?,
        @Query("skip") skip: Int
    ): Response<UserResponse>

    @GET("users/{refID}")
    suspend fun getIndividualUser(@Path("refID") refID: Int): Response<UserDetailsModel>

    companion object {
        operator fun invoke(): ApiService {
            val BASE_IP = "https://dummyjson.com/"
            return Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .baseUrl(BASE_IP)
                .client(getOkHTTPClient())
                .build()
                .create(ApiService::class.java)
        }

        private val DATE_FORMATS = arrayOf(
            "dd/MM/yyyy HH:mm:ss",
            "dd/MM/yyyy"
        )

        private fun getGson(): Gson = GsonBuilder()
            .registerTypeAdapter(String::class.java, HtmlAdapter())
            .setDateFormat(DATE_FORMATS[0])
            .setDateFormat(DATE_FORMATS[1])
            .setLenient()
            .create()

        fun getOkHTTPClient(): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
                level=HttpLoggingInterceptor.Level.BODY
            }).build()
        }
    }

}


