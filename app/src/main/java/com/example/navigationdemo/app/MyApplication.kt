package com.example.navigationdemo.app

import android.app.Application
import android.content.Context
import com.kakayun.lib_frameworkk.utils.SharedPreferencesUtils
import com.kakayun.lib_frameworkk.weight.loadCallBack.EmptyCallback
import com.kakayun.lib_frameworkk.weight.loadCallBack.ErrorCallback
import com.kakayun.lib_frameworkk.weight.loadCallBack.LoadingCallback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir

/**
 * Created by YuHang
 * c
 * 1/7/21 4:13 PM
 */
class MyApplication: Application(){

    companion object{
        lateinit var mContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        SharedPreferencesUtils.init(this)

        //界面加载管理 初始化
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())//加载
            .addCallback(ErrorCallback())//错误
            .addCallback(EmptyCallback())//空
            .setDefaultCallback(SuccessCallback::class.java)//设置默认加载状态页
            .commit()
    }
}