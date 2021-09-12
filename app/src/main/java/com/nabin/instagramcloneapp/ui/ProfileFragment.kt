
package com.nabin.instagramcloneapp.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mikhaellopez.circularimageview.CircularImageView
import com.mikhaellopez.circularimageview.CircularImageView.ShadowGravity
import com.nabin.instagramcloneapp.R




class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val circularImageView: CircularImageView = view.findViewById(R.id.circularImageView)
        // Set Color
//        circularImageView.setCircleColor(Color.BLACK);
// or with gradient
//        circularImageView.setCircleColorStart(Color.BLACK);
//        circularImageView.setCircleColorEnd(Color.RED);
//        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Set Border
        circularImageView.borderWidth = 10f
        circularImageView.borderColor = Color.WHITE
        // or with gradient
//        circularImageView.setBorderColorStart(Color.BLACK);
//        circularImageView.setBorderColorEnd(Color.RED);
//        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

// Add Shadow with default param
        circularImageView.shadowEnable = true
        // or with custom param
        circularImageView.shadowRadius = 7f
        circularImageView.shadowColor = Color.RED
        circularImageView.shadowGravity = ShadowGravity.CENTER
        return view
    }
}
