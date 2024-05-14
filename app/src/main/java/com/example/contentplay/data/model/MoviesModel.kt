package com.example.contentplay.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.contentplay.data.room_database.converters.MovieDataConverter

@Entity(tableName = "movies_table")
data class MoviesModel(
    @PrimaryKey val movieId: Int,
    val movieName: String,
    val movieDescription: String,
    val movieThumbnail: String,
    val videoURL: String,
    @TypeConverters(MovieDataConverter::class) val genres: List<String>,
    @TypeConverters(MovieDataConverter::class) val movieCast: List<String>
)

/*
* 212, "Superman", Superhero movie", "https://movieURL.png", "https://movieURL.com/superman/video/endpoint",[Genre{"Action","Romance","Comedy"}]
* */