package com.example.contentplay.data.api

import com.example.contentplay.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
* Structure of API URL -
*     Example - https://apipreprod.sonyliv.com/AGL/2.7/R/ENG/ANDROID_TAB/IN/KA/FEATURE/CONFIG?
*     Base URL - https://apipreprod.sonyliv.com
*     End Points - /AGL/2.7/R/ENG/ANDROID_TAB/IN/KA/FEATURE/CONFIG?
* */
class RetrofitInstance {


    /*Structure of API -
    * Headers
    * Request -> Body
    * Response -> Body
    *Tests
    * Code -> 200 (Success), 400, 404, 405, 402, 401, 301, 300,.............
    * */
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiInterface: ContentPlayApiInterface by lazy {
            retrofit.create(ContentPlayApiInterface::class.java)
        }
    }
}