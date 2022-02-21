package com.example.lawpavillionandroidassessment.utils

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat


fun toggleViewBackground(viewCallback: ViewCallback) {
    viewCallback.toggleBackground()
}

fun setViewBackgroundColor(view: View, backgroundColor: Int, context: Context, strokeColor: Int, strokeWidth: Int) {
    val drawable: GradientDrawable = view.background as GradientDrawable
    drawable.setColor(ContextCompat.getColor(context, backgroundColor))
    drawable.setStroke(strokeWidth, strokeColor)

}
