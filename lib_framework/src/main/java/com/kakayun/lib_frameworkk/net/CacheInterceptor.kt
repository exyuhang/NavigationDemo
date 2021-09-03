package com.kakayun.lib_frameworkk.net

import com.kakayun.lib_frameworkk.base.MyApplication
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by YuHang
 * c
 * 2021/9/3 11:13 上午
 */
class CacheInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return if (!NetworkUtils.isNetwork(MyApplication.mContext)) {
            val newRequest = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
            chain.proceed(newRequest)
        } else {
            val maxTime = 24 * 60 * 60
            val response = chain.proceed(request)
            response.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxTime")
                .removeHeader("Progma")
                .build()
        }
    }
}