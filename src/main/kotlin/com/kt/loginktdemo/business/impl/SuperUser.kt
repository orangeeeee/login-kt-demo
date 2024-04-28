package com.kt.loginktdemo.business.impl

import com.kt.loginktdemo.business.User

class SuperUser(val name: String, val postalCode: Int, override val email: String) : User {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }

    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }

}