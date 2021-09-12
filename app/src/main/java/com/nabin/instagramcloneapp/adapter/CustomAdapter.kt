package com.nabin.instagramcloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nabin.instagramcloneapp.R
import java.util.ArrayList

class CustomAdapter(var images: ArrayList<*>, var context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource((images[position] as Int))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView

        init {
            imageView = view.findViewById(R.id.image)
        }
    }
}