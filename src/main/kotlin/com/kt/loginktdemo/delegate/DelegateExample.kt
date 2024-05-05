package com.kt.loginktdemo.delegate

class DelegateExample {
    val heavy by lazy {
        println("Heavy calculation")
        "Heavy"
    }
}