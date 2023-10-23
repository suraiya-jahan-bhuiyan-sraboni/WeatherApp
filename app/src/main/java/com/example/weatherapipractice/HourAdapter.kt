package com.example.weatherapipractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapipractice.weather.Hour
import kotlin.math.round

class HourAdapter(context: Context,private val hour:List<Hour>): RecyclerView.Adapter<HourAdapter.HourViewholder>() {
    class HourViewholder(view: View):RecyclerView.ViewHolder(view) {
        val time:TextView=view.findViewById(R.id.time)
        val temp:TextView=view.findViewById(R.id.temp)
        val conditn:TextView=view.findViewById(R.id.conditions)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourAdapter.HourViewholder {
        return HourViewholder(LayoutInflater.from(parent.context).inflate(R.layout.hour_list,parent,false))
    }

    override fun onBindViewHolder(holder: HourAdapter.HourViewholder, position: Int) {
        val item=hour[position]
        holder.time.text=item.datetime
        holder.temp.text= round(item.temp).toString()+"\u00B0 F"
        holder.conditn.text=item.conditions
    }

    override fun getItemCount(): Int {
        return hour.size
    }
}