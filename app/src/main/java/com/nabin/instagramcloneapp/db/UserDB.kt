package com.nabin.instagramcloneapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nabin.instagramcloneapp.dao.UserDAO
import com.nabin.instagramcloneapp.entity.users


@Database(
    entities = [(users::class)],
    version = 1,
    exportSchema = false
)
abstract class UserDB : RoomDatabase() {


    abstract fun getUserDAO(): UserDAO

    companion object {
        @Volatile
        var instance: UserDB? = null

        fun getInstance(Context: Context): UserDB {
            if (instance == null) {
                synchronized(UserDB::class) {
                    instance = buildDatabase(Context)
                }
            }
            return instance!!
        }

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "UserDB"
            ).build()
    }
}