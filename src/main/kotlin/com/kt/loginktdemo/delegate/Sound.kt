package com.kt.loginktdemo.delegate

open class Sound(private val speaker: Speaker) : Speaker by speaker {
    fun play() {
        println("Sound is playing")
    }
}