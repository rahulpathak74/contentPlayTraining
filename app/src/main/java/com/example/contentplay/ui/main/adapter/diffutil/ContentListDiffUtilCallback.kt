package com.example.contentplay.ui.main.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.contentplay.data.model.MoviesModelAPI

class ContentListDiffUtilCallback(
    private val oldList: List<MoviesModelAPI>?,
    private val newList: List<MoviesModelAPI>?
) :DiffUtil.Callback(){
        override fun getOldListSize(): Int = oldList?.size ?: 0

        override fun getNewListSize(): Int = newList?.size ?: 0

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList?.get(oldItemPosition)?.movieId == newList?.get(newItemPosition)?.movieId


        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList?.get(oldItemPosition) == newList?.get(newItemPosition)

}