package com.kt.loginktdemo.delegate

class Robot(soundBehavior: SoundBehavior, lightBehavior: LightBehavior) : SoundBehavior by soundBehavior,
    LightBehavior by lightBehavior