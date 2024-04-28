package com.kt.loginktdemo.business.impl

class NormalUser(val name: String) {
    var address: String = "unspecified"
        set(value) {
            println(
                """
                Address was changed for $name: "$field" -> "$value".
            """.trimIndent()
            )
            field = value
        }
}