package com.kt.loginktdemo.endpoint.response.dto

class GreetingResponse(datetime: String, message: String) {
    var datetime: String
    var message: String

    init {
        this.datetime = datetime
        this.message = message
    }
}