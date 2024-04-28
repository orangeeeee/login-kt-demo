package com.kt.loginktdemo.business

interface User {

    val email: String
    val nickname: String
        get() = email.substringBefore('@')

}