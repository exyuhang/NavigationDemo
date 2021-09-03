package com.example.navigationdemo.ui.activity

import android.Manifest
import com.example.navigationdemo.R
import com.example.navigationdemo.databinding.ActivityMainBinding
import com.kakayun.lib_frameworkk.base.BaseActivity
import com.kakayun.lib_frameworkk.base.BaseViewModel
import com.kakayun.lib_frameworkk.ext.toast
import com.permissionx.guolindev.PermissionX

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()
        val permissions: Array<String> = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        PermissionX.init(this)
            .permissions(*permissions)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    toast(this, "All permissions are granted")
                } else {
                    toast(this, "These permissions are denied: $deniedList")
                }
            }
    }
}
