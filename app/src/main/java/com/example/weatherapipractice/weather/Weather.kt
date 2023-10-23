package com.example.weatherapipractice.weather


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "address")
    val address: String,
    @Json(name = "days")
    val days:List<Day>,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "queryCost")
    val queryCost: Int,
    @Json(name = "resolvedAddress")
    val resolvedAddress: String,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "tzoffset")
    val tzoffset: Double
)