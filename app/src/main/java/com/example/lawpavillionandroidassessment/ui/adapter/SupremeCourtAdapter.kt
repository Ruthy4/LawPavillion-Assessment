package com.example.lawpavillionandroidassessment.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.R
import com.example.lawpavillionandroidassessment.databinding.SupremeCourtRecyclerViewItemBinding
import com.example.lawpavillionandroidassessment.domain.model.SupremeCourt
import com.example.lawpavillionandroidassessment.utils.DiffCallback
import androidx.constraintlayout.widget.ConstraintLayout


class SupremeCourtAdapter(
    private val onItemClick: (SupremeCourt) -> Unit
) :
    RecyclerView.Adapter<SupremeCourtAdapter.ViewHolder>() {

    private var supremeCourtList = emptyList<SupremeCourt>()

    private var selectedItem = -1
    private var lastSelected = -1

    inner class ViewHolder(
        private val binding: SupremeCourtRecyclerViewItemBinding,
        private val onItemClick: (SupremeCourt) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(supremeCourt: SupremeCourt, position: Int) {

            binding.apply {
                folderTitleTextView.text = supremeCourt.title
                deliveryDateTextView.text = supremeCourt.deliveryDate
                referenceNumber.text = supremeCourt.referenceNumber

                val backgroundResource: Int =
                    if (position == selectedItem) R.drawable.ic_selected_folder_bg
                    else R.drawable.ic_unselected_folder
                val textColor: Int =
                    if (position == selectedItem) R.color.white
                    else R.color.black


                supremeCourtFolder.setBackgroundResource(backgroundResource)
                folderTitleTextView.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        textColor
                    )
                )
                deliveryDateTextView.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        textColor
                    )
                )
                referenceNumber.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        textColor
                    )
                )

                supremeCourtFolder.setOnClickListener {
                    lastSelected = selectedItem;
                    selectedItem = position;

                    notifyItemChanged(lastSelected);
                    notifyItemChanged(selectedItem);

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

    fun setData(supremeCourt: MutableList<SupremeCourt>) {
        val supremeCourtDiffUtil = DiffCallback(supremeCourtList, supremeCourt)
        val supremeCourtDiffUtilResult = DiffUtil.calculateDiff(supremeCourtDiffUtil)
        this.supremeCourtList = supremeCourt
        supremeCourtDiffUtilResult.dispatchUpdatesTo(this)
    }
}

