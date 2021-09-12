package com.nabin.instagramcloneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.mikhaellopez.circularimageview.CircularImageView
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.model.PostModel

class PostAdapter(private val listData: Array<PostModel>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.post_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storyModel = listData[position]
        holder.name.text = storyModel.name
        holder.imageView.setImageResource(storyModel.image)
        holder.date.text = storyModel.date
        holder.postImage.setImageResource(storyModel.postImg)
        holder.description.text = storyModel.description
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var description: TextView
        var date: TextView
        var postImage: ImageView
        var imageView: CircularImageView

        init {
            imageView = itemView.findViewById(R.id.profile_image)
            name = itemView.findViewById(R.id.profile_name)
            date = itemView.findViewById(R.id.profile_date)
            description = itemView.findViewById(R.id.post_description)
            postImage = itemView.findViewById(R.id.post_image)
        }
    }
}