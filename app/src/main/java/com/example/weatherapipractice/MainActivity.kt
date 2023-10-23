package com.example.weatherapipractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapipractice.weather.Weather
import com.example.weatherapipractice.network.ApiClient.apiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Tem:TextView=findViewById(R.id.tempe)
        val date:TextView=findViewById(R.id.date)
        val sun:ImageView=findViewById(R.id.sun)
        val moon:ImageView=findViewById(R.id.moon)
        val srise:TextView=findViewById(R.id.sunrise)
        val sset:TextView=findViewById(R.id.sunset)
        val feellike:TextView=findViewById(R.id.feelslike)
        val con:TextView=findViewById(R.id.conditon)
        val place:TextView=findViewById(R.id.place)
        val hour:RecyclerView=findViewById(R.id.hour)

        val hourlyWeather= apiClient.getHourlyWeather().enqueue(object :Callback<Weather>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                val response = response.body()
                val responseList = response?.days?.get(0)
                val hourResponse = responseList?.hours
                Tem.text = Math.round(responseList?.temp!!).toString()+"\u00B0 F"
                date.text= responseList.datetime
                sset.text="Sunset: "+responseList.sunset
                srise.text="Sunrise: "+responseList.sunrise
                feellike.text= "Feelslike "+responseList.feelslike.toString()+"\u00B0 F"
                place.text=response.resolvedAddress
                con.text=responseList.conditions

                with(Tem) { visibility = View.VISIBLE }
                with(date) { visibility = View.VISIBLE }
                with(sun) { visibility = View.VISIBLE }
                with(moon) { visibility = View.VISIBLE }
                with(srise) { visibility = View.VISIBLE }
                with(sset) { visibility = View.VISIBLE }
                with(feellike) { visibility = View.VISIBLE }
                with(con) { visibility = View.VISIBLE }
                with(place) { visibility = View.VISIBLE }
                with(hour) { visibility = View.VISIBLE }
                hour.adapter = HourAdapter(this@MainActivity, hourResponse!!)

            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Toast.makeText(this@MainActivity, "network failed", Toast.LENGTH_SHORT).show()
            }

        })

    }
}