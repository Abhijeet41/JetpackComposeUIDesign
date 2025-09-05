package com.abhi41.composeuipractice.screen.sample_data

data class Property(
    val type: String,
    val title: String,
    val address: String,
    val pickPath: String,
    val price: Int,
    val bed: Int,
    val bath: Int,
    val size: Int,
    val isGarage: Boolean,
    val score: Double,
    val description: String
)
