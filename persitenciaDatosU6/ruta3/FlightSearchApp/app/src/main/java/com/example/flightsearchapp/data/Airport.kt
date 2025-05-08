package com.example.flightsearchapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val iataCode: String,
    val name: String,
    val city: String,
    val country: String
)