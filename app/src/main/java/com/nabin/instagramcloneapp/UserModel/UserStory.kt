package com.nabin.instagramcloneapp.UserModel

import android.os.Parcel
import android.os.Parcelable

data class UserStory(
        val id: String? =null,
        val name:String?=null,
        val description:String?=null,
        val userStoryImg:String?=null
):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(id)
                parcel.writeString(name)
                parcel.writeString(description)
                parcel.writeString(userStoryImg)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<UserStory> {
                override fun createFromParcel(parcel: Parcel): UserStory {
                        return UserStory(parcel)
                }

                override fun newArray(size: Int): Array<UserStory?> {
                        return arrayOfNulls(size)
                }
        }

}