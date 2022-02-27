package com.example.lawpavillionandroidassessment.domain.model

data class SupremeCourt(
    val title: String,
    val deliveryDate: String,
    val referenceNumber: String,
    var isClicked: Boolean = false
    )