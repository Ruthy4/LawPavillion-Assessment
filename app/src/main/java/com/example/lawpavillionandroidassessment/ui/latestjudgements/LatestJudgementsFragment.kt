package com.example.lawpavillionandroidassessment.ui.latestjudgements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lawpavillionandroidassessment.R
import com.example.lawpavillionandroidassessment.databinding.FragmentLatestJudgementsBinding
import com.example.lawpavillionandroidassessment.ui.adapter.SupremeCourtAdapter
import com.example.lawpavillionandroidassessment.utils.*

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
        _binding = FragmentLatestJudgementsBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        supremeCourtRecyclerView = binding.supremeCourtRecyclerView
        supremeCourtAdapter = SupremeCourtAdapter { supremeCourt ->

            binding.apply {
                childFragmentContainer.showView()
                notificationCardView.hideView()
                floatingActionButton.hideView()

                activity?.supportFragmentManager?.commit {
                    replace<SupremeCourtFolderFragment>(R.id.child_fragment_container)
                    setReorderingAllowed(true)
                }
            }
        }

        supremeCourtRecyclerView.adapter = supremeCourtAdapter
        supremeCourtRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 4,
                GridLayoutManager.VERTICAL, false)
        supremeCourtAdapter.setData(SupremeCourtList.supremeCourtList)

        toggleOnSpecificLayout(binding.supremeCourtLayout, binding.supremeCourtTextView)

        binding.apply {
            supremeCourtLayout.setOnClickListener {
                toggleOnSpecificLayout(it, binding.supremeCourtTextView)
                courtOfAppealRecyclerView.hideView()
                supremeCourtRecyclerView.showView()
            }
            courtOfAppealLayout.setOnClickListener {
                toggleOnSpecificLayout(it, binding.courtOfAppealTextView)
                courtOfAppealRecyclerView.showView()
                supremeCourtRecyclerView.hideView()
                childFragmentContainer.hideView()
            }
        }
    }

    fun toggleOffAllLayout() {
        binding.apply {
            setViewBackgroundColor(
                supremeCourtLayout,
                R.color.lotion, requireContext(),
                R.color.lotion, 0
            )
            setViewBackgroundColor(
                courtOfAppealLayout,
                R.color.lotion, requireContext(),
                R.color.lotion, 0
            )
            supremeCourtTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.cadet_grey
                )
            )
            courtOfAppealTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.cadet_grey
                )
            )
        }
    }

    private fun toggleOnSpecificLayout(backgroundView: View, textView: TextView) {
        toggleViewBackground(object : ViewCallback {
            override fun toggleBackground() {
                toggleOffAllLayout()
            }
        })
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.nickel))
        setViewBackgroundColor(backgroundView, R.color.white,
            requireContext(), R.color.platinum, 1)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}