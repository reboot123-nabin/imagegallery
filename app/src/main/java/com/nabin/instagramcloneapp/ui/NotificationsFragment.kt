package com.nabin.instagramcloneapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nabin.instagramcloneapp.R


class NotificationsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView = root.findViewById<TextView>(R.id.text_notifications)
        textView.text = "notification"
        return root
    }
}