package com.example.navigationdemo.data.repository

import com.example.navigationdemo.app.net.HttpClient


/**
 * Created by YuHang
 *
 * 1/7/21 3:58 PM
 */
val httpRepository: HttpRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    HttpRepository()
}

class HttpRepository {

    suspend fun getArticlelList(pageNo: Int)
            = HttpClient.getInstance().getApiService().getArticlelList(pageNo)

    suspend fun getBannerData() = HttpClient.getInstance().getApiService().getBanner()

}