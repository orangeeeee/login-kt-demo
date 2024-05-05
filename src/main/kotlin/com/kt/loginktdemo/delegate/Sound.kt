package com.kt.loginktdemo.delegate

open class Sound : SoundBehavior {
    override fun makeSound() {
        println("音を鳴らす!")
    }
}