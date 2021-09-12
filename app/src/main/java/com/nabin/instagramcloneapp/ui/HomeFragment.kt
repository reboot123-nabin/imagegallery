package com.nabin.instagramcloneapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nabin.instagramcloneapp.R
import com.nabin.instagramcloneapp.adapter.PostAdapter
import com.nabin.instagramcloneapp.adapter.StoryAdapter
import com.nabin.instagramcloneapp.model.PostModel
import com.nabin.instagramcloneapp.model.StoryModel



class HomeFragment : Fragment() {
    private lateinit var storyRecycl:RecyclerView
    private lateinit var postRecycler:RecyclerView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        storyRecycl = root.findViewById(R.id.story_recycler)
        val storyModels = arrayOf(
            StoryModel(R.drawable.dog, "Khaliq"),
            StoryModel(R.drawable.cat, "Izrail"),
            StoryModel(R.drawable.hamster, "KdTechs"),
            StoryModel(R.drawable.dog, "Youtube"),
            StoryModel(R.drawable.cat, "Example"),
            StoryModel(R.drawable.hamster, "Testing"),
            StoryModel(R.drawable.dog, "Youtube"),
            StoryModel(R.drawable.cat, "Example"),
            StoryModel(R.drawable.hamster, "Testing"))
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        storyRecycl.setLayoutManager(layoutManager)
        val storyAdapter = StoryAdapter(storyModels)
        storyRecycl.setAdapter(storyAdapter)


        //============================ Post area
        postRecycler = root.findViewById(R.id.post_recycler)
        postRecycler.setLayoutManager(LinearLayoutManager(activity))
        postRecycler.setHasFixedSize(true)
        val postModels = arrayOf(
            PostModel("Khaliq", R.drawable.dog, R.drawable.dog, "19-05-2021", "A Quick brown fox jumps"),
            PostModel("Izrail", R.drawable.cat, R.drawable.cat, "19-05-2021", "a lazy dog"),
            PostModel("KDtechs", R.drawable.hamster, R.drawable.hamster, "19-05-2021", "A Quick brown fox jumps"),
            PostModel("Khaliq", R.drawable.dog, R.drawable.dog, "19-05-2021", "A Quick brown fox jumps"),
            PostModel("Izrail", R.drawable.cat, R.drawable.cat, "19-05-2021", "a lazy dog"),
            PostModel("KDtechs", R.drawable.hamster, R.drawable.hamster, "19-05-2021", "A Quick brown fox jumps"))
        val adapter = PostAdapter(postModels)
        postRecycler.setAdapter(adapter)
        return root
    }
}