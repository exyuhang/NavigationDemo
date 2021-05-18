package com.example.navigationdemo.viewmodel

import androidx.lifecycle.LiveData
import com.example.navigationdemo.app.MyApplication
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.app.room.UserInfo
import com.example.navigationdemo.data.repository.LocalRepository

/**
 * Created by YuHang
 * c
 * 2020/12/18 11:39 AM
 */
class HomeViewModel : BaseViewModel() {

    private val homeRepository by lazy {
        LocalRepository(MyApplication.mContext)
    }


    fun getAllUserInfo(): LiveData<List<UserInfo>> {
        return homeRepository.getAllUserInfo()
    }

    fun insertUserInfo(vararg userInfo: UserInfo) {
        homeRepository.insertUserInfo(*userInfo)
    }

    fun deleteUserInfo(vararg userInfo: UserInfo) {
        homeRepository.deleteUserInfo(*userInfo)
    }

    fun updateUserInfo(vararg userInfo: UserInfo) {
        homeRepository.updateUserInfo(*userInfo)
    }

    fun clearUserInfo() {
        homeRepository.clearUserInfo()
    }


}