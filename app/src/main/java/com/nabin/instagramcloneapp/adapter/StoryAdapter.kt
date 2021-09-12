package com.nabin.instagramcloneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.mikhaellopez.circularimageview.CircularImageView
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.model.StoryModel

class StoryAdapter(private val listData: Array<StoryModel>) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.story_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storyModel = listData[position]
        holder.name.text = storyModel.name
        holder.imageView.setImageResource(storyModel.image)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var imageView: CircularImageView

        init {
            imageView = itemView.findViewById(R.id.story_image)
            name = itemView.findViewById(R.id.story_name)
        }
    }
}