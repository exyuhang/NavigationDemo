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

    suspend fun getCarousel(mapData: MutableMap<String, String>)
            = HttpClient.getInstance().getApiService().carousel(mapData)

}