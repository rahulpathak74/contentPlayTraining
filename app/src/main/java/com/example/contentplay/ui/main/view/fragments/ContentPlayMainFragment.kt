package com.example.contentplay.ui.main.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.contentplay.data.repository.ContentPlayRepository
import com.example.contentplay.data.room_database.database.ContentPlayDatabase
import com.example.contentplay.ui.base.ContentPlayViewModelFactory
import com.example.contentplay.ui.main.viewmodel.ContentPlayViewModel
import com.example.contentplay.utils.LiveNetworkChecker

class ContentPlayMainFragment: Fragment() {

    private lateinit var contentPlayViewModel: ContentPlayViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        context?.let { context ->
            val repository = ContentPlayRepository(ContentPlayDatabase.getDatabase(context))
            val factory = ContentPlayViewModelFactory(repository)
            contentPlayViewModel = ViewModelProvider(this, factory)[ContentPlayViewModel::class.java]
        }

        LiveNetworkChecker.init(requireActivity().application)
        if(!LiveNetworkChecker.hasObservers()) {
            LiveNetworkChecker.observe(viewLifecycleOwner) { isAvailable ->
             if(isAvailable) {
                 contentPlayViewModel.getContentFromServer()
             }
            }
        }
        observe()
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observe() {
        contentPlayViewModel.moviesDataLiveData.observe(viewLifecycleOwner) {
            // Show same data in UI
        }
    }
}