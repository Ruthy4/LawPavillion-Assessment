package com.example.lawpavillionandroidassessment.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.lawpavillionandroidassessment.domain.model.SupremeCourt

class DiffCallback(
    private val oldList: List<SupremeCourt>,
    private val newList: List<SupremeCourt>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].deliveryDate == newList[newItemPosition].deliveryDate
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].referenceNumber == newList[newItemPosition].referenceNumber
    }
}