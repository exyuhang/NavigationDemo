package com.example.navigationdemo.data.repository

import android.content.Context
import android.os.AsyncTask
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
    private var userInfoLive: LiveData<List<UserInfo>>

    constructor(context: Context){
        val userInfoDatabase = UserInfoDatabase.getUserInfoDatabase(context)
        userInfoDao = userInfoDatabase.getUserInfoDao()
        userInfoLive = userInfoDao.getAllUserInfo()
    }

    fun getAllUserInfo(): LiveData<List<UserInfo>>{
        return userInfoLive
    }

    fun insertUserInfo(vararg userInfo: UserInfo){
        InsertTask(
            userInfoDao
        ).execute(*userInfo)
    }

    fun deleteUserInfo(vararg userInfo: UserInfo){
        DeleteTask(
            userInfoDao
        ).execute(*userInfo)
    }

    fun updateUserInfo(vararg userInfo: UserInfo){
        UpdateTask(
            userInfoDao
        ).execute(*userInfo)
    }

    fun clearUserInfo(){
        ClearTask(
            userInfoDao
        ).execute()
    }

    companion object{

        private class InsertTask(val userInfoDao: UserInfoDao): AsyncTask<UserInfo, Void, Void>(){

            override fun doInBackground(vararg params: UserInfo): Void? {
                userInfoDao.insertUserInfo(*params)
                return null
            }

        }

        private class DeleteTask(val userInfoDao: UserInfoDao): AsyncTask<UserInfo, Void, Void>(){

            override fun doInBackground(vararg params: UserInfo): Void? {
                userInfoDao.deleteUserInfo(*params)
                return null
            }

        }

        private class UpdateTask(val userInfoDao: UserInfoDao): AsyncTask<UserInfo, Void, Void>(){

            override fun doInBackground(vararg params: UserInfo): Void? {
                userInfoDao.updateUserInfo(*params)
                return null
            }

        }

        private class ClearTask(val userInfoDao: UserInfoDao): AsyncTask<Void, Void, Void>(){

            override fun doInBackground(vararg params: Void): Void? {
                userInfoDao.deleteAllUserInfo()
                return null
            }

        }
    }

}