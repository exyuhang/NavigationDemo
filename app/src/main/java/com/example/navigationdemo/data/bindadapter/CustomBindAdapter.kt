package com.example.navigationdemo.data.bindadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.navigationdemo.app.ext.glide

/**
 * Created by YuHang
 * c
 * 2021/7/12 4:28 下午
 */
object CustomBindAdapter {

    @JvmStatic
    @BindingAdapter("glide")
    fun glide(imageView: ImageView, imgUrl: String) {
        imageView.glide(imgUrl)
    }

}