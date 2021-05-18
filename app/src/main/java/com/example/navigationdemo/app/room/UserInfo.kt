package com.example.navigationdemo.app.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by YuHang
 * c
 * 2020/12/17 10:05 AM
 */
@Entity(tableName = "USER_INFO")
class UserInfo (name: String, age: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = name

    @ColumnInfo(name = "age")
    var age: Int = age

}