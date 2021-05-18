package com.kakayun.lib_frameworkk.net

import com.kakayun.lib_frameworkk.BuildConfig
import com.kakayun.lib_frameworkk.utils.logi
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import okio.GzipSource
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by YuHang
 * 网络请求日志拦截器
 * 2020/9/23 10:27 PM
 */
class HttpLogInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (BuildConfig.DEBUG) {
            printRequestInfo(request)
        }
        val response = chain.proceed(request)
        if (BuildConfig.DEBUG) {
            printResponseBody(request.url.toString(), response)
        }
        return response
    }

    private fun printRequestInfo(request: Request) {
        request.url.toString().logi("OkHttp")
    }

    /**
     * 打印响应体
     */
    @Throws(IOException::class)
    private fun printResponseBody(url: String, response: Response) {
        val headers = response.headers
        val responseBody = response.body
        if (responseBody != null) {
            val contentLength = responseBody.contentLength()
            val source = responseBody.source()
            source.request(Long.MAX_VALUE) // Buffer the entire body.
            var buffer = source.buffer()
            var gzippedLength: Long? = null
            if ("gzip".equals(headers["Content-Encoding"], ignoreCase = true)) {
                gzippedLength = buffer.size
                var gzippedResponseBody: GzipSource? = null
                try {
                    gzippedResponseBody = GzipSource(buffer.clone())
                    buffer = Buffer()
                    buffer.writeAll(gzippedResponseBody)
                } finally {
                    gzippedResponseBody?.close()
                }
            }
            var charset = Charset.forName("UTF-8")
            val contentType = responseBody.contentType()
            if (contentType != null) {
                charset = contentType.charset(Charset.forName("UTF-8"))
            }
            if (contentLength != 0L) {
                 //打印响应的json
                """
                    url:$url
                    ResponseBody:${buffer.clone().readString(charset!!)}
                    """.trimIndent().logi("OkHttp")
            }
            if (gzippedLength != null) {
                """
                    url:$url
                    <-- END HTTP (${buffer.size}-byte, $gzippedLength-gzipped-byte body)
                    """.trimIndent().logi("OkHttp")
            } else {
                """
                    url:$url
                    <-- END HTTP (${buffer.size}-byte body)
                    """.trimIndent().logi("OkHttp")
            }
        }
    }
}