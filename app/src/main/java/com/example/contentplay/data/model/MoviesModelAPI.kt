package com.example.contentplay.data.model

import com.google.gson.annotations.SerializedName


data class MoviesModelAPI(
    @SerializedName("") val movieId: Int,
    @SerializedName("") val movieName: String,
    @SerializedName("") val movieDescription: String,
    @SerializedName("")  val movieThumbnail: String,
    @SerializedName("") val videoURL: String,
    @SerializedName("") val genres: List<String>? = arrayListOf(),
    @SerializedName("") val movieCast: List<String>? = arrayListOf()
)