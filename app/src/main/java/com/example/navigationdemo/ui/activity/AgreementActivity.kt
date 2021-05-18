package com.example.navigationdemo.ui.activity

import android.util.Log
import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseActivity
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.ActivityAgreementBinding

/**
 * Created by YuHang
 * c
 * 2020/12/14 3:56 PM
 */
class AgreementActivity: BaseActivity<BaseViewModel, ActivityAgreementBinding>(){

    override fun getLayoutId(): Int =
        R.layout.activity_agreement

    override fun initView() {
        window.setBackgroundDrawableResource(R.color.transparent)
        Log.e("传值", intent?.getStringExtra("userName")!!)
    }


}