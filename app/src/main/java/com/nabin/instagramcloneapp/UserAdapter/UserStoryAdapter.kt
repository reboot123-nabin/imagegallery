package com.nabin.instagramcloneapp.UserAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.bumptech.glide.Glide
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.UserModel.UserStory
import de.hdodenhof.circleimageview.CircleImageView

class UserStoryAdapter(

    val lststory:ArrayList<UserStory>,
    val context:Context):RecyclerView.Adapter<UserStoryAdapter.StoryViewholder>() {
    class StoryViewholder(view:View):RecyclerView.ViewHolder(view){
        val story_profile:CircleImageView;
        val story_name: TextView;
        init {
            story_profile=view.findViewById(R.id.storyImg)
            story_name=view.findViewById(R.id.name);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewholder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_story,parent,false)
        return StoryViewholder(view)
    }

    override fun getItemCount(): Int {
        return lststory.size
    }

    override fun onBindViewHolder(holder: StoryViewholder, position: Int) {
        val story=lststory[position];
        holder.story_name.text=story.name;
        Glide.with(context)
                .load(story.userStoryImg)
                .into(holder.story_profile)
    }
}