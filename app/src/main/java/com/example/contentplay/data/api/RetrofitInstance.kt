package com.example.contentplay.data.api

import com.example.contentplay.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Structure of API URL -
*     Example - https://apipreprod.sonyliv.com/AGL/2.7/R/ENG/ANDROID_TAB/IN/KA/FEATURE/CONFIG?
*     Base URL - https://apipreprod.sonyliv.com
*     End Points - /AGL/2.7/R/ENG/ANDROID_TAB/IN/KA/FEATURE/CONFIG?
* */
class RetrofitInstance {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiInterface: ContentPlayApiInterface by lazy {
            retrofit.create(ContentPlayApiInterface::class.java)
        }
    }
}