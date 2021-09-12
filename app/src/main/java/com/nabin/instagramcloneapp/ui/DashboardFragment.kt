package com.nabin.instagramcloneapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.adapter.CustomAdapter


import java.util.*

class DashboardFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    var images: ArrayList<*> = ArrayList(Arrays.asList(R.drawable.cat, R.drawable.dog, R.drawable.hamster, R.drawable.test, R.drawable.facebook, R.drawable.twitter, R.drawable.instagram, R.drawable.snapchat, R.drawable.cat,
        R.drawable.dog, R.drawable.hamster, R.drawable.test, R.drawable.facebook, R.drawable.twitter, R.drawable.instagram, R.drawable.snapchat))

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerView = root.findViewById(R.id.recycler)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        recyclerView.setLayoutManager(staggeredGridLayoutManager)
        val customAdapter = context?.let { CustomAdapter(images, it) }
        recyclerView.setAdapter(customAdapter)
        return root
    }

    // to hide the action bar
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }
}