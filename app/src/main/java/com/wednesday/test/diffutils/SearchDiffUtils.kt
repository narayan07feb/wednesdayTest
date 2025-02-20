package com.wednesday.test.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.wednesday.test.model.Result

class SearchDiffUtils(val newList: MutableList<Result>, val oldList: MutableList<Result>) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition];
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition];
    }

}