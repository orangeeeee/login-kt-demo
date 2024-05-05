package com.kt.loginktdemo.delegate

class Light(override val name: String) : Speaker {
    fun illuminate() {
        println("illuminate is on")
    }
}