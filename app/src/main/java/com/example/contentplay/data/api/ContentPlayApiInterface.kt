package com.example.contentplay.data.api


import androidx.lifecycle.LiveData
import com.example.contentplay.data.model.MoviesModelAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentPlayApiInterface {

    @GET("/api/v1/movies")
    suspend fun getContentFromServer(): Response<List<MoviesModelAPI>>
}