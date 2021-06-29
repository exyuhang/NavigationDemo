package com.example.navigationdemo.app.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by YuHang
 * c
 * 2020/12/17 10:23 AM
 */
@Dao
interface UserInfoDao {
    @Insert
    suspend fun insertUserInfo(vararg userInfo: UserInfo)

    @Update
    suspend fun updateUserInfo(vararg userInfo: UserInfo)

    @Delete
    suspend fun deleteUserInfo(vararg userInfo: UserInfo)

    @Query("DELETE FROM USER_INFO")
    suspend fun deleteAllUserInfo()

    @Query("SELECT * FROM USER_INFO ORDER BY ID DESC")
    fun getAllUserInfo(): LiveData<List<UserInfo>>
}