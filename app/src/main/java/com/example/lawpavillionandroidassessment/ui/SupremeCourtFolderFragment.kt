package com.example.lawpavillionandroidassessment.ui

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.lawpavillionandroidassessment.R
import com.example.lawpavillionandroidassessment.databinding.FragmentSupremeCourtFolderBinding
import com.example.lawpavillionandroidassessment.utils.CustomTypefaceSpan
import com.example.lawpavillionandroidassessment.utils.ViewCallback
import com.example.lawpavillionandroidassessment.utils.setViewBackgroundColor
import com.example.lawpavillionandroidassessment.utils.toggleViewBackground

class SupremeCourtFolderFragment : Fragment() {
    private var _binding: FragmentSupremeCourtFolderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSupremeCourtFolderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newUserSignUpForFreeSpannable()
        toggleOnSpecificLayout(binding.readFullSummaryTextView, binding.readFullSummaryTextView)

        binding.viewSummaryTextView.setOnClickListener {
            binding.fullJudgementTextView.visibility =View.GONE
            toggleOnSpecificLayout(it, binding.viewSummaryTextView)
        }

        binding.readFullSummaryTextView.setOnClickListener {
            binding.fullJudgementTextView.visibility =View.VISIBLE
            toggleOnSpecificLayout(it, binding.readFullSummaryTextView)
        }
    }


    private fun newUserSignUpForFreeSpannable() {
        val message = getString(R.string.judgement_summary)
        val spannable = SpannableStringBuilder(message)
        val myTypeface = Typeface.create(ResourcesCompat.getFont(requireContext(), R.font.work_sans), Typeface.BOLD)
        spannable.setSpan(CustomTypefaceSpan(myTypeface), 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.deep_purple)), 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        spannable.setSpan(CustomTypefaceSpan(myTypeface), 8, 51, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.red)), 8, 51, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        spannable.setSpan(CustomTypefaceSpan(myTypeface), 50, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.green)), 50, message.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        binding.judgementSummaryTextView.text = spannable
        binding.judgementSummaryTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    fun toggleOffAllLayout() {
        binding.apply {
            setViewBackgroundColor(viewSummaryTextView,
                R.color.white, requireContext(),
                R.color.platinum,0 )
            setViewBackgroundColor(readFullSummaryTextView,
                R.color.white, requireContext(),
                R.color.platinum, 0)
            viewSummaryTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.deep_purple
            ))
            readFullSummaryTextView.setTextColor(ContextCompat.getColor(requireContext(),
                R.color.deep_purple
            ))
        }
    }

    private fun toggleOnSpecificLayout(backgroundView: View, textView: TextView) {
        toggleViewBackground(object : ViewCallback {
            override fun toggleBackground() {
                toggleOffAllLayout()
            }
        })
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        setViewBackgroundColor(backgroundView, R.color.orange, requireContext(), R.color.orange, 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}