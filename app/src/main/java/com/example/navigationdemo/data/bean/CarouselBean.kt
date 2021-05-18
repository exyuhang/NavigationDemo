package com.example.navigationdemo.data.bean

import com.kakayun.lib_frameworkk.net.Constants

/**
 * Created by YuHang
 * 轮播图
 * 1/7/21 2:48 PM
 */

data class CarouselBean(
    val des: String,
    val id: String,
    val imginfo: String,
    val img: String,
    val time: String
){
    var imgUrl: String = ""
    get() = Constants.BASE_IMG + img

}

