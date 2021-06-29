package com.kakayun.lib_frameworkk.utils

import android.annotation.SuppressLint
import android.content.Context

/**
 * 基于一个Android比较方便存储系统
 */
@SuppressLint("StaticFieldLeak")
object SharedPreferencesUtils {
    /**
     * 上下文
     */
    private lateinit var mContext: Context

    /**
     * 初始化SharedPreferences，必须使用该方法
     */
    fun init(context: Context) {
        mContext = context
    }

    /**
     * 抛出异常
     */
    private fun throwInit() {
        if (mContext == null) {
            throw NullPointerException("在使用该方法前，需要使用init()方法，推荐将init()放入Application中")
        }
    }

    /**
     * 插入字符串
     *
     * @param name  文件名
     * @param key   key
     * @param value 值
     */
    fun putString(name: String, key: String, value: String) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putString(key, value)
        edit.apply()
    }

    /**
     * 获取字符串
     *
     * @param name         文件名
     * @param key          key
     * @param defaultValue 没获取到时的默认值
     * @return 字符串
     */
    fun getString(name: String, key: String, defaultValue: String): String {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getString(key, defaultValue)?:""
    }

    /**
     * 插入整型
     *
     * @param name  文件名
     * @param key   key
     * @param value 值
     */
    fun putInt(name: String, key: String, value: Int) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putInt(key, value)
        edit.apply()
    }

    /**
     * 获取整型
     *
     * @param name         文件名
     * @param key          key
     * @param defaultValue 没获取到时的默认值
     * @return 整型
     */
    fun getInt(name: String, key: String, defaultValue: Int): Int {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getInt(key, defaultValue)
    }

    /**
     * 插入浮点型
     *
     * @param name  文件名
     * @param key   key
     * @param value 值
     */
    fun putFloat(name: String, key: String, value: Float) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putFloat(key, value)
        edit.apply()
    }

    /**
     * 获取浮点型
     *
     * @param name         文件名
     * @param key          key
     * @param defaultValue 没获取到时的默认值
     * @return 浮点型
     */
    fun getFloat(name: String, key: String, defaultValue: Float): Float {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getFloat(key, defaultValue)
    }

    /**
     * 插入Long型
     *
     * @param name  文件名
     * @param key   key
     * @param value 值
     */
    fun putLong(name: String, key: String, value: Long) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putLong(key, value)
        edit.apply()
    }

    /**
     * 获取长整型
     *
     * @param name         文件名
     * @param key          key
     * @param defaultValue 没获取到时的默认值
     * @return 长整型
     */
    fun getLong(name: String, key: String, defaultValue: Long): Float {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getLong(key, defaultValue).toFloat()
    }

    /**
     * 插入boolean型
     *
     * @param name  文件名
     * @param key   key
     * @param value 值
     */
    fun putBoolean(name: String, key: String, value: Boolean) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.putBoolean(key, value)
        edit.apply()
    }

    /**
     * 获取布尔型
     *
     * @param name         文件名
     * @param key          key
     * @param defaultValue 没获取到时的默认值
     * @return 布尔型
     */
    fun getBoolean(name: String, key: String, defaultValue: Boolean): Boolean {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getBoolean(key, defaultValue)
    }

    /**
     * 清除数据
     */
    fun clearData(name: String) {
        throwInit()
        val sp = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        val edit = sp.edit()
        edit.clear()
        edit.apply()
    }
}