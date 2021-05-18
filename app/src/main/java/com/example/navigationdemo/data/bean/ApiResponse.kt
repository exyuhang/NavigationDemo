package com.example.navigationdemo.data.bean

import com.kakayun.lib_frameworkk.net.BaseResponse


data class ApiResponse<T>(val code: Int, val msg: String, val result: T) : BaseResponse<T>() {

    override fun isSuccess() = code == 200

    override fun getResponseCode() = code

    override fun getResponseData() = result

    override fun getResponseMsg() = msg

}