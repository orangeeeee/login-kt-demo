package com.kt.loginktdemo.delegate

class DynamicProperties(userMap: Map<String, Any?>) {
    val name: String by userMap
    val age: Int by userMap
    val email: String by userMap
}