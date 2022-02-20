package com.example.lawpavillionandroidassessment.ui.adapter

import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.databinding.SupremeCourtRecyclerViewItemBinding
import com.example.lawpavillionandroidassessment.domain.model.SupremeCourtModel

class SupremeCourtAdapter: RecyclerView.Adapter<SupremeCourtAdapter.ViewHolder>() {

    var supremeCourtList = emptyList<SupremeCourtModel>()

class ViewHolder(val binding: SupremeCourtRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root){

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount() = supremeCourtList.size
}

object DiffCallback: DiffUtil.ItemCallback<SupremeCourtModel>() {
    override fun areItemsTheSame(
        oldItem: SupremeCourtModel,
        newItem: SupremeCourtModel
    ): Boolean {
        return
    }

    override fun areContentsTheSame(
        oldItem: SupremeCourtModel,
        newItem: SupremeCourtModel
    ): Boolean {
    }

}