package com.example.contentplay.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contentplay.data.model.MoviesModelAPI
import com.example.contentplay.data.repository.ContentPlayRepository
import com.example.contentplay.utils.AppConstants.TAG
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ContentPlayViewModel(private var repository: ContentPlayRepository): ViewModel() {

    private var moviesData = MutableLiveData<List<MoviesModelAPI>>()
    val moviesDataLiveData:LiveData<List<MoviesModelAPI>>
        get() = moviesData
    fun getContentFromServer() {
        viewModelScope.launch {
            val response = try {
                repository.getContentFromServer()
            } catch (e: IOException) {
                Log.e(TAG,"IOException, You might not have an active internet connection", )
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HTTPException intercepted")
                return@launch
            }

            if(response.isSuccessful && response.body() != null) {
                Log.d(TAG, response.body().toString())
                moviesData.value = response.body()
            }
        }
    }
}