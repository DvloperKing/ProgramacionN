package com.example.flightsearchapp.data

data class Flight(
    val id: Int,
    val departureCode: String,
    val destinationCode: String,
    val departureTime: String,
    val arrivalTime: String,
    val price: Double
)