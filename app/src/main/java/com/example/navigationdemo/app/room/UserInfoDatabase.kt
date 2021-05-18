package com.example.navigationdemo.app.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by YuHang
 * c
 * 2020/12/17 10:37 AM
 */
@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
abstract class UserInfoDatabase : RoomDatabase() {

    companion object {
        private var instance: UserInfoDatabase? = null

        @Synchronized
        fun getUserInfoDatabase(context: Context): UserInfoDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserInfoDatabase::class.java,
                    "user_info_database"
                )
                    .build()
            }
            return instance!!
        }
    }

    abstract fun getUserInfoDao(): UserInfoDao

}