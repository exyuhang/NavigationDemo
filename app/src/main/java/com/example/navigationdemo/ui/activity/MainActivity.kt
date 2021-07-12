package com.example.navigationdemo.ui.activity

import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.ActivityMainBinding
import com.kakayun.lib_frameworkk.base.BaseActivity
import com.kakayun.lib_frameworkk.base.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main
}
