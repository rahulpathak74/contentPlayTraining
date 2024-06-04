package com.example.contentplay.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.contentplay.R
import com.example.contentplay.data.model.MoviesModelAPI
import com.example.contentplay.databinding.CardMoviesItemBinding
import com.example.contentplay.ui.main.adapter.diffutil.ContentListDiffUtilCallback
import java.lang.Exception

class ContentListingAdapter (
    private var contentArrayList: ArrayList<MoviesModelAPI>
) : RecyclerView.Adapter<ContentListingAdapter.ContentPlayViewHolder>() {

    private lateinit var mBinding: CardMoviesItemBinding

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentPlayViewHolder {
        context = parent.context
        mBinding =  CardMoviesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ContentPlayViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ContentPlayViewHolder, position: Int) {
        val content = contentArrayList[position]

        holder.bind(content)

        //Glide library to load images into ImageView
        Glide
            .with(mBinding.movieImage)
            .load(content.movieThumbnail)
            .placeholder(R.drawable.ic_launcher_background) //Placeholder image if poster-image value is empty
            .into(mBinding.movieImage)
    }

    fun updatedListFromDatabase(filterList: ArrayList<MoviesModelAPI>) {
        try {
            val diffUtilCallback = ContentListDiffUtilCallback(this.contentArrayList, filterList)
            val diffCalculation  = DiffUtil.calculateDiff(diffUtilCallback)
            contentArrayList.clear()
            contentArrayList.addAll(filterList)
            diffCalculation.dispatchUpdatesTo(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount() = contentArrayList.size

   inner class ContentPlayViewHolder(binding: CardMoviesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(modelAPI: MoviesModelAPI) {
           mBinding.contentPlayModel = modelAPI
        }
    }
}