package com.example.contentplay.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentPlayApiInterface {

    @GET("/test/endpoint.json")
    suspend fun getContentFromServer(): Response<List<Any>>

    @GET("/test/endpoint2_{songName}.json")
    suspend fun getTheAudioFileForSearchedSong(@Path("songName") songName: String) : Response<Any>
}