package com.nabin.instagramcloneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nabin.instagramcloneapp.adapter.CustomAdapter
import java.util.*

class GalleryActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    var images: ArrayList<*> = ArrayList(Arrays.asList(R.drawable.cat, R.drawable.dog, R.drawable.hamster, R.drawable.test, R.drawable.facebook, R.drawable.twitter, R.drawable.instagram, R.drawable.snapchat, R.drawable.cat,
            R.drawable.dog, R.drawable.hamster, R.drawable.test, R.drawable.facebook, R.drawable.twitter, R.drawable.instagram, R.drawable.snapchat))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        recyclerView = findViewById(R.id.recycler)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        recyclerView.setLayoutManager(staggeredGridLayoutManager)
        val customAdapter = CustomAdapter(images, this@GalleryActivity)
        recyclerView.setAdapter(customAdapter)
    }
    // to hide the action bar
    override fun onResume() {
        super.onResume()
        (this@GalleryActivity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (this@GalleryActivity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
}