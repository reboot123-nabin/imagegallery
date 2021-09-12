package com.nabin.instagramcloneapp.UserAdapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.bumptech.glide.Glide
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.UserModel.UserPost

import de.hdodenhof.circleimageview.CircleImageView

class UserPostAdapter(
    val userList: ArrayList<UserPost>,
    val context: Context
    ):RecyclerView.Adapter<UserPostAdapter.UserViewHolder>(){
        class UserViewHolder(view: View): RecyclerView.ViewHolder(view){

            val imgProfile: CircleImageView
            val tvName : TextView
            val tvDecription:TextView
            val  imgThreedots: ImageView
            val  imgLike : ImageView
            val  imgShare : ImageView
            val  imgCmnt : ImageView
            val  uploadedImg : ImageView

            init {
                tvDecription=view.findViewById(R.id.tvDescribe)
                imgProfile = view.findViewById(R.id.imgProfile)
                tvName = view.findViewById(R.id.tvName)
                imgThreedots = view.findViewById(R.id.imgThreedots)
                imgLike= view.findViewById(R.id.imgLike)
                imgShare = view.findViewById(R.id.imgShare)
                imgCmnt = view.findViewById(R.id.imgCmnt)
                uploadedImg = view.findViewById(R.id.uploadedImg)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_instapost_layout,  parent, false)
        return  UserViewHolder(view)    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val users =  userList[position]
        //Log.d("user","This is new user")
        holder.tvName.text = users.userName
        holder.tvDecription.text=users.userdescribe
        Glide.with(context).load(users.userProfileImg).into(holder.imgProfile)
        Glide.with(context).load(users.userPostImg).into(holder.uploadedImg)
        Glide.with(context).load(users.postlikeImg).into(holder.imgLike)
        Glide.with(context).load(users.postcmntImg).into(holder.imgCmnt)
        Glide.with(context).load(users.postshareImg).into(holder.imgShare)
        Glide.with(context).load(users.threedotImg).into(holder.imgThreedots)



    }

    override fun getItemCount(): Int {
       return userList.size
    }
}
