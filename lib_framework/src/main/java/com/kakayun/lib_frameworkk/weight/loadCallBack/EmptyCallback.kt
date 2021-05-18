package com.kakayun.lib_frameworkk.weight.loadCallBack

import com.kakayun.lib_frameworkk.R
import com.kingja.loadsir.callback.Callback


class EmptyCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }

}