package com.kakayun.lib_frameworkk.net

import java.lang.RuntimeException

/**
 * Created by YuHang
 * c
 * 1/7/21 3:03 PM
 */
class ApiException(val code: Int, override val message: String?): RuntimeException(){

}