package com.kakayun.lib_frameworkk.net

import android.util.Log
import com.kakayun.lib_frameworkk.utils.Md5Utils
import com.kakayun.lib_frameworkk.utils.UserUtils.getToken
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.URLDecoder
import java.util.*

/**
 * Created by YuHang
 * 自定义请求拦截器添加公参及签名
 * 2020/9/23 10:27 PM
 */
class RequestInterceptor : Interceptor {
    private val strSalt = "siyutwo2.cn"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.header("XX-Device-Type", "android")
        requestBuilder.header("XX-Token", getToken())
        var map: MutableMap<String, String> = HashMap()
        val date = Date()
        map["mytiemstype"] = (date.time / 1000).toString()
        if (request.body is FormBody) {
            val newFormBody = FormBody.Builder()
            val oldFormBody = request.body as FormBody?
            for (i in 0 until oldFormBody!!.size) {
                newFormBody.addEncoded(oldFormBody.encodedName(i), oldFormBody.encodedValue(i))
                map[oldFormBody.encodedName(i)] = oldFormBody.encodedValue(i) //添加key和value值
            }
            val list: List<Map.Entry<String, String>> =
                ArrayList<Map.Entry<String, String>>(map.entries) //entrySet显示全部键值对
            Collections.sort(
                list
            ) { o1, o2 ->
                // 升序排序
                //进行key比较
                o1.key.compareTo(o2.key)
            }
            val stringBuffer = StringBuffer()
            for (i in list.indices) {
                stringBuffer.append(list[i].toString().trim { it <= ' ' } + "&")
            }
            val value = stringBuffer.substring(0, stringBuffer.length - 1).toString()
            newFormBody.add("mytiemstype", (date.time / 1000).toString())
            newFormBody.add(
                "sign",
                Md5Utils.toMd5(Md5Utils.toMd5(strSalt) + Md5Utils.toMd5(URLDecoder.decode(value)))
            )
            requestBuilder.method(request.method, newFormBody.build())
            Log.e(
                "---newFormBody---",
                "&sign:" + Md5Utils.toMd5(
                    Md5Utils.toMd5(strSalt) + Md5Utils.toMd5(
                        URLDecoder.decode(
                            value
                        )
                    )
                ).toString() + value
            )
        }
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}