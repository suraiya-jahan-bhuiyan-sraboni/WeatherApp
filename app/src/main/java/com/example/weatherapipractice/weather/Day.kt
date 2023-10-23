package com.example.weatherapipractice.weather


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Day(
    @Json(name = "conditions")
    val conditions: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "feelslike")
    val feelslike: Double,
    @Json(name = "hours")
    val hours:List <Hour>,
    @Json(name = "sunrise")
    val sunrise: String,
    @Json(name = "sunset")
    val sunset: String,
    @Json(name = "temp")
    val temp: Double
)