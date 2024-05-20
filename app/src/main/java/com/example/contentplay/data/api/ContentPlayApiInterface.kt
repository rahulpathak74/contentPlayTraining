package com.example.contentplay.data.api


import androidx.lifecycle.LiveData
import com.example.contentplay.data.model.MoviesModelAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentPlayApiInterface {

    @GET("/test/endpoint.json")
    suspend fun getContentFromServer(): Response<List<MoviesModelAPI>>

    @GET("/test/endpoint2_{songName}.json")
    suspend fun getTheAudioFileForSearchedSong(@Path("songName") songName: String) : Response<MoviesModelAPI>

    // Upcoming Sessions - > DI (later) -> Call API in repository and view model -> Make API call and show data in RecyclerView
}