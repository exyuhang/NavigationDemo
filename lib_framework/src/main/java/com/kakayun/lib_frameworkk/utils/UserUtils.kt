package com.kakayun.lib_frameworkk.utils

import android.content.Context


/**
 * Created by YuHang
 * 用户信息工具类
 * 2020/9/28 9:29 AM
 */

object UserUtils {
    private const val SP_NAME = "USER_INFO"
    private const val TOKEN = "SHARED_KEY_TOKEN" //获取token
    private const val USER_ID = "USER_ID"

    fun init(context: Context) {
        SharedPreferencesUtils.init(context)
    }

    fun setUserId(userId: String) {
        SharedPreferencesUtils.putString(SP_NAME, USER_ID, userId)
    }

    fun getUserId(): String {
        return SharedPreferencesUtils.getString(SP_NAME, USER_ID, "")
    }


    fun setToken(token: String) {
        SharedPreferencesUtils.putString(SP_NAME, TOKEN, token)
    }

    fun getToken(): String {
        return SharedPreferencesUtils.getString(SP_NAME, TOKEN, "")
    }

    //清除数据
    fun clearData() {
        SharedPreferencesUtils.clearData(SP_NAME)
    }
}