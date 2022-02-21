package com.example.lawpavillionandroidassessment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.databinding.SupremeCourtRecyclerViewItemBinding
import com.example.lawpavillionandroidassessment.domain.model.SupremeCourtModel

class SupremeCourtAdapter :
    ListAdapter<SupremeCourtModel, SupremeCourtAdapter.ViewHolder>(DiffCallback) {

    var supremeCourtList = emptyList<SupremeCourtModel>()

    class ViewHolder(private val binding: SupremeCourtRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(supremeCourtModel: SupremeCourtModel) {
            binding.folderTitleTextView.text = supremeCourtModel.title
            binding.deliveryDateTextView.text = supremeCourtModel.deliveryDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SupremeCourtRecyclerViewItemBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = supremeCourtList.size
}

object DiffCallback : DiffUtil.ItemCallback<SupremeCourtModel>() {
    override fun areItemsTheSame(
        oldItem: SupremeCourtModel,
        newItem: SupremeCourtModel
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: SupremeCourtModel,
        newItem: SupremeCourtModel
    ): Boolean {
        return oldItem == newItem
    }
}