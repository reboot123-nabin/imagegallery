package com.bishaljung.instagramcloneapp.UserModel

import android.os.Parcel
import android.os.Parcelable

class AddNewPost (
        val postimg:String?=null,
        val profileimg:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(postimg)
        parcel.writeString(profileimg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddNewPost> {
        override fun createFromParcel(parcel: Parcel): AddNewPost {
            return AddNewPost(parcel)
        }

        override fun newArray(size: Int): Array<AddNewPost?> {
            return arrayOfNulls(size)
        }
    }
}