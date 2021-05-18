package com.example.navigationdemo.app.net

import com.example.navigationdemo.data.bean.ApiResponse
import com.example.navigationdemo.data.bean.CarouselBean
import com.kakayun.lib_frameworkk.net.Constants
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by YuHang
 * c
 * 1/7/21 1:55 PM
 */
interface ApiService {

    /**
     * 轮播图
     */
    @POST(Constants.CAROUSEL)
    @FormUrlEncoded
    suspend fun carousel(@FieldMap mapData: Map<String, String>): ApiResponse<ArrayList<CarouselBean>>
}