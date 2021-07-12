package com.kakayun.lib_frameworkk.net

import com.kakayun.lib_frameworkk.utils.UserUtils.getToken
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by YuHang
 * 自定义请求拦截器添加公参及签名
 * 2020/9/23 10:27 PM
 */
class RequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        /*requestBuilder.header("XX-Device-Type", "android")
        requestBuilder.header("XX-Token", getToken())*/
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}