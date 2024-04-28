package com.kt.loginktdemo.business.impl

import com.kt.loginktdemo.business.Clickable
import com.kt.loginktdemo.business.Focusable

@Suppress("UNREACHABLE_CODE")
class Button : Clickable, Focusable {
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        TODO("Not yet implemented")
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

//    override fun showOff() {
//        TODO("Not yet implemented")
//    }
}