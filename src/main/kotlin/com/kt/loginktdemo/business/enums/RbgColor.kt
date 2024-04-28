package com.kt.loginktdemo.business.enums

// 引数はメンバー
enum class RbgColor(val r:Int,val g:Int,val b:Int) {


    RED(9,0,0),BLUE(1,0,0),GREEN(0,0,0),  YELLOW(0,0,0), BLACK(0,0,0);

    fun rgb() =(r * 256 + g) * 256 + b;
}