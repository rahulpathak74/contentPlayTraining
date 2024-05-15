package com.example.contentplay.data.repository

import androidx.lifecycle.LiveData
import com.example.contentplay.data.api.RetrofitInstance
import com.example.contentplay.data.model.MoviesModel
import com.example.contentplay.data.model.MoviesModelAPI
import com.example.contentplay.data.room_database.database.ContentPlayDatabase
import retrofit2.Response

class ContentPlayRepository(database: ContentPlayDatabase) {

    private val contentPlayDAO = database.contentPlayDao()

    suspend fun addMovieDataToDB(movies: List<MoviesModel>) {
        contentPlayDAO.addMovieDataToDB(movies)
    }

    fun readAllMoviesFromDB(): LiveData<List<MoviesModel>> {
        return contentPlayDAO.readAllMoviesFromDB()
    }

    fun readAllMoviesFromDBWithSearch(query: String): LiveData<List<MoviesModel>> {
        return contentPlayDAO.readAllMoviesFromDBWithSearch(query)
    }

    suspend fun deleteMoviesDataFromDB() {
        contentPlayDAO.deleteMoviesDataFromDB()
    }

    suspend fun getContentFromServer(): Response<List<MoviesModelAPI>> {
       return RetrofitInstance.apiInterface.getContentFromServer()
    }

}