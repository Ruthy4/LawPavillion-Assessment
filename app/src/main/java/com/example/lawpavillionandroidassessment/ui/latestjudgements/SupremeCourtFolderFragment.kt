package com.example.lawpavillionandroidassessment.ui.latestjudgements

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.lawpavillionandroidassessment.R
import com.example.lawpavillionandroidassessment.databinding.FragmentSupremeCourtFolderBinding
import com.example.lawpavillionandroidassessment.utils.*

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


        binding.apply {
            viewSummaryTextView.setOnClickListener {
                fullJudgementTextView.hideView()
                toggleOnSpecificLayout(it, viewSummaryTextView)
            }
            readFullSummaryTextView.setOnClickListener {
                fullJudgementTextView.showView()
                toggleOnSpecificLayout(it, readFullSummaryTextView)
            }
            toggleOnSpecificLayout(readFullSummaryTextView, readFullSummaryTextView)

        }
        binding.closeButton.setOnClickListener {

        }
    }


    private fun newUserSignUpForFreeSpannable() {
        val messageTitle = getString(R.string.judgement_summary)
        val messageBody = getString(R.string.full_judgement)
        val spannableTitle = SpannableStringBuilder(messageTitle)
        val spannableBody = SpannableStringBuilder(messageBody)
        val myTypeface = Typeface.create(ResourcesCompat.getFont(requireContext(), R.font.work_sans), Typeface.BOLD)
        spannableTitle.setSpan(CustomTypefaceSpan(myTypeface), 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableTitle.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.deep_purple)), 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        spannableTitle.setSpan(CustomTypefaceSpan(myTypeface), 8, 51, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableTitle.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.red)), 8, 51, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        spannableTitle.setSpan(CustomTypefaceSpan(myTypeface), 50, messageTitle.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableTitle.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.green)), 50, messageTitle.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableBody.setSpan(StyleSpan(Typeface.BOLD), 200, messageBody.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableBody.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.red)), 200, messageBody.length,  Spannable.SPAN_INCLUSIVE_INCLUSIVE)


        binding.apply {
            judgementSummaryTextView.text = spannableTitle
            judgementSummaryTextView.movementMethod = LinkMovementMethod.getInstance()
        }
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