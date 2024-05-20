package com.example.contentplay.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contentplay.data.repository.ContentPlayRepository
import com.example.contentplay.ui.main.viewmodel.ContentPlayViewModel

class ContentPlayViewModelFactory(
    private val repository: ContentPlayRepository)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContentPlayViewModel::class.java)) {
            return ContentPlayViewModel(repository) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel Class")
    }

}