package com.example.contentplay.data.api

import com.example.contentplay.data.di.DaggerAppComponent
import com.example.contentplay.data.model.MoviesModelAPI
import retrofit2.Response

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

    lateinit var apiInterface: ContentPlayApiInterface

    init {
        DaggerAppComponent.create().inject(this)
    }

    suspend fun readDataFromServer(): Response<List<MoviesModelAPI>> {
      return  apiInterface.getContentFromServer()
    }

}