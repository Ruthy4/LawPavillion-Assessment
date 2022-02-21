package com.example.lawpavillionandroidassessment

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.databinding.FragmentLatestJudgementsBinding
import com.example.lawpavillionandroidassessment.ui.adapter.SupremeCourtAdapter
import com.example.lawpavillionandroidassessment.utils.SupremeCourtList
import com.example.lawpavillionandroidassessment.utils.ViewCallback
import com.example.lawpavillionandroidassessment.utils.setViewBackgroundColor
import com.example.lawpavillionandroidassessment.utils.toggleViewBackground

class LatestJudgementsFragment : Fragment() {
    private var _binding: FragmentLatestJudgementsBinding? = null
    private val binding get() = _binding!!
    lateinit var supremeCourtRecyclerView: RecyclerView
    lateinit var supremeCourtAdapter: SupremeCourtAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLatestJudgementsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        supremeCourtRecyclerView = binding.supremeCourtRecyclerView
        supremeCourtAdapter = SupremeCourtAdapter()
        supremeCourtRecyclerView.adapter = supremeCourtAdapter
        supremeCourtAdapter.submitList(SupremeCourtList.supremeCourtList)

        binding.supremeCourtLayout.setOnClickListener {
            toggleOnSpecificLayout(it, binding.supremeCourtTextView)
        }

        binding.courtOfAppealLayout.setOnClickListener {
            toggleOnSpecificLayout(it, binding.courtOfAppealTextView)
        }
    }

    fun toggleOffAllLayout() {
        binding.apply {
            setViewBackgroundColor(supremeCourtLayout, R.color.lotion, requireContext(),R.color.lotion,0 )
            setViewBackgroundColor(courtOfAppealLayout, R.color.lotion, requireContext(), R.color.lotion, 0)
            supremeCourtTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.cadet_grey))
            courtOfAppealTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.cadet_grey))
        }
    }

    private fun toggleOnSpecificLayout(backgroundView: View, textView: TextView) {
        toggleViewBackground(object : ViewCallback {
            override fun toggleBackground() {
                toggleOffAllLayout()
            }
        })
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.nickel))
        setViewBackgroundColor(backgroundView, R.color.white, requireContext(), R.color.platinum, 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}