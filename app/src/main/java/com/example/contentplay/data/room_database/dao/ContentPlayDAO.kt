package com.example.contentplay.data.room_database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contentplay.data.model.MoviesModel

@Dao
interface ContentPlayDAO {

    // Insert movie data in database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieDataToDB(movies: MoviesModel): Long

    @Query("SELECT * FROM movies_table")
    fun readAllMoviesFromDB(): LiveData<List<MoviesModel>>

    @Query("SELECT * FROM movies_table WHERE genres LIKE :query")
    fun readAllMoviesFromDBWithSearch(query: String): LiveData<List<MoviesModel>>

    @Query("DELETE FROM movies_table")
    fun deleteMoviesDataFromDB()

}