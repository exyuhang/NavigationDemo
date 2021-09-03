package com.example.navigationdemo.app.net

import com.kakayun.lib_frameworkk.net.CacheInterceptor
import com.kakayun.lib_frameworkk.net.Constants
import com.kakayun.lib_frameworkk.net.HttpLogInterceptor
import com.kakayun.lib_frameworkk.net.RequestInterceptor
import com.kakayun.lib_frameworkk.utils.FileUtils
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by YuHang
 * c
 * 2020/9/23 10:26 PM
 */
class HttpClient {

    private val services: HashMap<String, ApiService> = HashMap()


    init {
        initHttp(Constants.BASE_URL)
    }

    /**
     * @param newBaseUrl 若baseUrl不同则传入此参数
     */
    fun getApiService(vararg newBaseUrl: String): ApiService {
        var baseUrl = Constants.BASE_URL
        if (newBaseUrl.isNotEmpty()) {
            baseUrl = newBaseUrl[0]
            if (services[baseUrl] == null) {
                initHttp(baseUrl)
            }
        }
        return services[baseUrl]!!
    }

    /**
     * 初始化网络请求
     */
    private fun initHttp(baseUrl: String) {

        //添加Cache拦截器，有网时添加到缓存中，无网时取出缓存
        val file: File = FileUtils.getInstance().cacheFolder
        val cache = Cache(file, 1024 * 1024 * 100)
        val client = OkHttpClient
            .Builder()
            .addInterceptor(CacheInterceptor())
            .addInterceptor(RequestInterceptor())
            .addInterceptor(HttpLogInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .cache(cache)
//            .addNetworkInterceptor(StethoInterceptor())
            .build()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        services[baseUrl] = apiService
    }

    fun createJsonBody(json: String): RequestBody {
        return RequestBody.create("application/json;charset=UTF-8".toMediaTypeOrNull(), json)
    }

    companion object {
        @Volatile
        private var instance: HttpClient? = null

        fun getInstance() = instance
                ?: synchronized(this) {
            instance
                    ?: HttpClient().also { instance = it }
        }
    }
}