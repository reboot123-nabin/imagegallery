package com.bishaljung.instagramcloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bishaljung.instagramcloneapp.UserAdapter.UserPostAdapter
import com.bishaljung.instagramcloneapp.UserModel.AddNewPost
import com.bishaljung.instagramcloneapp.UserModel.UserPost

class AddPostActivity : AppCompatActivity() {
    private lateinit var tvprofileimg: TextView;
    private lateinit var tvpostimg: TextView;
    private lateinit var post:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        tvprofileimg=findViewById(R.id.tvprofileimg)
        tvpostimg=findViewById(R.id.tvpostimg)
        post=findViewById(R.id.post)
        post.setOnClickListener{
            val UserPost=AddNewPost(tvprofileimg.text.toString(), tvpostimg.text.toString())
            val intent= Intent()
            intent.putExtra("UserPost", UserPost)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}