package com.example.navigationdemo.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.navigationdemo.app.room.UserInfo
import com.example.navigationdemo.app.room.UserInfoDao
import com.example.navigationdemo.app.room.UserInfoDatabase

/**
 * Created by YuHang
 * c
 * 2020/12/18 2:16 PM
 */

class LocalRepository {
    private var userInfoDao: UserInfoDao

    constructor(context: Context){
        val userInfoDatabase = UserInfoDatabase.getUserInfoDatabase(context)
        userInfoDao = userInfoDatabase.getUserInfoDao()
    }

    fun getAllUserInfo(): LiveData<List<UserInfo>>{
        return userInfoDao.getAllUserInfo()
    }

    suspend fun insertUserInfo(vararg userInfo: UserInfo){
        userInfoDao.insertUserInfo(*userInfo)
    }

    suspend fun deleteUserInfo(vararg userInfo: UserInfo){
        userInfoDao.deleteUserInfo(*userInfo)
    }

    suspend fun updateUserInfo(vararg userInfo: UserInfo){
        userInfoDao.updateUserInfo(*userInfo)
    }

    suspend fun clearUserInfo(){
        userInfoDao.deleteAllUserInfo()
    }

}