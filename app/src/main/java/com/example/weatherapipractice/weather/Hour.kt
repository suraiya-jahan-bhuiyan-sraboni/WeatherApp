package com.example.weatherapipractice.weather


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hour(
    @Json(name = "conditions")
    val conditions: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "feelslike")
    val feelslike: Double,
    @Json(name = "temp")
    val temp: Double
)