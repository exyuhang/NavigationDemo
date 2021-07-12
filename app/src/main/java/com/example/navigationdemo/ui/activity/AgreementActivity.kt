package com.example.navigationdemo.ui.activity

import com.example.navigationdemo.R
import com.kakayun.lib_frameworkk.base.BaseActivity
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.example.navigationdemo.databinding.ActivityAgreementBinding
import com.kakayun.lib_frameworkk.ext.getBundle
import com.kakayun.lib_frameworkk.utils.loge

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
        getBundle(intent)?.apply {
            getString("userName", "空值").loge("传值")
        }

        //intent.getStringExtra("userName")?.loge("传值")
    }


}