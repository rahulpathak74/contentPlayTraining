package com.example.contentplay.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentplay.R
import com.example.contentplay.data.model.MoviesModelAPI

class ContentListingAdapter (
    private var contentArrayList: ArrayList<MoviesModelAPI>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var context: Context
    private var query: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_movies_item, parent, false)
        )
    }

    fun updatedListFromDatabase(filterList: ArrayList<MoviesModelAPI>) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val content = contentArrayList[position]

        //Glide library to load images into Imageviews
//        Glide
//            .with(movieImage)
//            .load(posterImageDrawableHelper(content))
//            .placeholder(R.drawable.placeholder_for_missing_posters) //Placeholder image if poster-image value is empty
//            .into(movieImage)

    }


    override fun getItemCount() = contentArrayList.size
}