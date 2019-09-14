package com.perusudroid.customscroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val mData : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.inflater_result, parent, false))
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDataToView(mData[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var tvTxt : TextView = itemView.findViewById(R.id.tvTxt)

        fun bindDataToView(txt: String) {
            tvTxt.text = txt
        }

    }

}