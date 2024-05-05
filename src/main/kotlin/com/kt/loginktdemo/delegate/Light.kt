package com.kt.loginktdemo.delegate

open class Light : LightBehavior {
    override fun illuminate() {
        println("光を放つ!")
    }
}