package com.example.contentplay.ui.main.view.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contentplay.R
import com.example.contentplay.data.repository.ContentPlayRepository
import com.example.contentplay.data.room_database.database.ContentPlayDatabase
import com.example.contentplay.databinding.FragmentContentPlayMainBinding
import com.example.contentplay.ui.base.ContentPlayViewModelFactory
import com.example.contentplay.ui.main.adapter.ContentListingAdapter
import com.example.contentplay.ui.main.viewmodel.ContentPlayViewModel
import com.example.contentplay.utils.AppConstants.TAG
import com.example.contentplay.utils.CommonUtils
import com.example.contentplay.utils.LiveNetworkChecker

class ContentPlayMainFragment: Fragment() {

    private lateinit var contentPlayViewModel: ContentPlayViewModel
    private lateinit var binding: FragmentContentPlayMainBinding
    private lateinit var adapter:ContentListingAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_content_play_main,container,false)
        context?.let { context ->
            val repository = ContentPlayRepository(ContentPlayDatabase.getDatabase(context))
            val factory = ContentPlayViewModelFactory(repository)
            contentPlayViewModel = ViewModelProvider(this, factory)[ContentPlayViewModel::class.java]
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LiveNetworkChecker.init(requireActivity().application)
        if(!LiveNetworkChecker.hasObservers()) {
            LiveNetworkChecker.observe(viewLifecycleOwner) { isAvailable ->
                if(isAvailable) {
                    contentPlayViewModel.getContentFromServer()
                }
            }
        }
        initAdapter()
        observe()
        insertDataIntoDatabase()
        updateNewData()
        deleteInsertedDataFromDatabase()
    }

    private fun updateNewData() {
        binding.tvUpdateData.setOnClickListener {
            Toast.makeText(requireContext(), "Updated Data!", Toast.LENGTH_SHORT).show()
            adapter.updatedListFromDatabase(CommonUtils.contentArrayListDiff)
        }
    }

    private fun insertDataIntoDatabase() {
        binding.tvAddData.setOnClickListener {
            Toast.makeText(requireContext(), "Inserted Data!", Toast.LENGTH_SHORT).show()
            //TODO Add dummy data into database
        }
    }

    private fun deleteInsertedDataFromDatabase() {
        binding.tvDeleteData.setOnClickListener {
            Toast.makeText(requireContext(), "Deleted Data!", Toast.LENGTH_SHORT).show()
            //TODO Delete dummy data from database
        }
    }

    private fun initAdapter() {
        binding.rvContentListing.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observe() {
        contentPlayViewModel.moviesDataLiveData.observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        adapter = ContentListingAdapter(CommonUtils.contentArrayList)
        binding.rvContentListing.adapter = adapter
    }
}