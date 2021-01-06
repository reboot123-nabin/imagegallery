package com.punam.instagramcloneapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.punam.instagramcloneapp.UserModel.AddNewPost

class AddPostActivity : AppCompatActivity() {
  //  lateinit var name: String;
    private lateinit var tvprofileimg: EditText;
    private lateinit var tvpostimg: EditText;
    private lateinit var post:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        tvprofileimg=findViewById(R.id.tvprofileimg)
        tvpostimg=findViewById(R.id.tvpostimg)
        post=findViewById(R.id.post)
        var name=intent.getStringExtra("name").toString()
//        val intent = Intent()
//        if (intent.extras != null) {
//            name= intent.getStringExtra("name").toString()
//            Toast.makeText(this,"$name",Toast.LENGTH_SHORT).show()
//        }

        post.setOnClickListener{
            val UserPost=AddNewPost(tvprofileimg.text.toString(), tvpostimg.text.toString(),name)
            val intent= Intent()
            intent.putExtra("UserPost", UserPost)
           // Toast.makeText(this,"$name",Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}