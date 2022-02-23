package com.example.lawpavillionandroidassessment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.R
import com.example.lawpavillionandroidassessment.databinding.SupremeCourtRecyclerViewItemBinding
import com.example.lawpavillionandroidassessment.domain.model.SupremeCourt
import com.example.lawpavillionandroidassessment.utils.DiffCallback

class SupremeCourtAdapter(
    private val onItemClick: (SupremeCourt) -> Unit
) :
    RecyclerView.Adapter<SupremeCourtAdapter.ViewHolder>() {

    private var supremeCourtList = emptyList<SupremeCourt>()

    class ViewHolder(
        private val binding: SupremeCourtRecyclerViewItemBinding,
        private val onItemClick: (SupremeCourt) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(supremeCourt: SupremeCourt, position: Int) {
            binding.apply {
                folderTitleTextView.text = supremeCourt.title
                deliveryDateTextView.text = supremeCourt.deliveryDate
                referenceNumber.text = supremeCourt.referenceNumber

                supremeCourtFolder.setOnClickListener {
                    if (position == adapterPosition) {
                        supremeCourtFolder.setBackgroundResource(
                            R.drawable.ic_selected_folder_bg
                        )
                        folderTitleTextView.setTextColor(ContextCompat
                            .getColor(binding.root.context, R.color.white))
                        deliveryDateTextView.setTextColor(ContextCompat
                            .getColor(binding.root.context, R.color.white))
                        referenceNumber.setTextColor(ContextCompat
                            .getColor(binding.root.context, R.color.white))

                    } else {
                        supremeCourtFolder.setBackgroundResource(
                            R.drawable.ic_unselected_folder
                        )
                    }
                    onItemClick.invoke(supremeCourt)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SupremeCourtRecyclerViewItemBinding.inflate(
            LayoutInflater
                .from(parent.context), parent, false
        )
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = supremeCourtList[position]
        holder.bind(currentItem, position)
    }

    override fun getItemCount() = supremeCourtList.size

    fun setData(supremeCourt: List<SupremeCourt>) {
        val supremeCourtDiffUtil = DiffCallback(supremeCourtList, supremeCourt)
        val supremeCourtDiffUtilResult = DiffUtil.calculateDiff(supremeCourtDiffUtil)
        this.supremeCourtList = supremeCourt
        supremeCourtDiffUtilResult.dispatchUpdatesTo(this)
    }
}

//interface RecyclerClickListener {
//    fun onItemCLick(position: Int, supremeCourtList: List<SupremeCourt>)
//}

