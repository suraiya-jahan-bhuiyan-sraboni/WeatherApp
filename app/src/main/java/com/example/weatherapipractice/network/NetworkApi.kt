package com.example.weatherapipractice.network

import com.example.weatherapipractice.weather.Weather
import com.example.weatherapipractice.network.NetworkApi.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface NetworkApi {

    @GET(endpoint)
    fun getHourlyWeather():Call<Weather>

    companion object{
        private val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

}
object ApiClient{

    val apiClient:NetworkApi by lazy {
        retrofit.create(NetworkApi::class.java)
    }
}