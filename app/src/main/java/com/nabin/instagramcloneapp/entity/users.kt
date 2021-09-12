package com.nabin.instagramcloneapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class users(
//        var fname:String?=null,
//        var lname:String?=null,
    var username:String?=null,
    var password:String?=null
) {
    @PrimaryKey(autoGenerate = true)
    var userId:Int=0
}