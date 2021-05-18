package com.kakayun.lib_frameworkk.utils

import okhttp3.internal.and
import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by YuHang
 * md5加密
 * 1/7/21 2:36 PM
 */
object Md5Utils {

    fun toMd5(content: String): String{
        val hash: ByteArray
        hash = try {
            MessageDigest.getInstance("MD5")
                .digest(content.toByteArray(charset("UTF-8")))
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("Huh, MD5 should be supported?", e)
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException("Huh, UTF-8 should be supported?", e)
        }

        val hex = StringBuilder(hash.size * 2)
        for (b in hash) {
            if (b and 0xFF < 0x10) hex.append("0")
            hex.append(Integer.toHexString(b and 0xFF))
        }
        return hex.toString()
    }
}