package com.nabin.instagramcloneapp.UserModel

import android.os.Parcel
import android.os.Parcelable

class UserProfileData(
        val cuid:Int?=null,
        val fname:String?=null,
        val lname:String?=null,
        val email:String?=null,
        val password:String?=null,
        val batch:String?=null,
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(cuid)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(batch)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserProfileData> {
        override fun createFromParcel(parcel: Parcel): UserProfileData {
            return UserProfileData(parcel)
        }

        override fun newArray(size: Int): Array<UserProfileData?> {
            return arrayOfNulls(size)
        }
    }

}