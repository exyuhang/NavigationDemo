package com.example.navigationdemo.app.net

import com.example.navigationdemo.data.bean.ApiPagerResponse
import com.example.navigationdemo.data.bean.ApiResponse
import com.example.navigationdemo.data.bean.AriticleResponse
import com.example.navigationdemo.data.bean.BannerResponse
import retrofit2.http.*

/**
 * Created by YuHang
 * c
 * 1/7/21 1:55 PM
 */
interface ApiService {

    /**
     * 轮播图
     */
    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>>

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun getArticlelList(@Path("page") pageNo: Int): ApiResponse<ApiPagerResponse<ArrayList<AriticleResponse>>>
}