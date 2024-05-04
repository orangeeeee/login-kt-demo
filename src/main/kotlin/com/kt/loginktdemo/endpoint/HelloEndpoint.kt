package com.kt.loginktdemo.endpoint

import com.kt.loginktdemo.business.SampleBusinessAPI
import com.kt.loginktdemo.endpoint.response.dto.HelloResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("kts")
class HelloEndpoint(private val sampleBusinessAPI: SampleBusinessAPI) {

    @GetMapping("get")
    fun helloEndpoint(): HelloResponse {

        val message = sampleBusinessAPI.find()

        val response = HelloResponse(
            datetime = LocalDateTime.now().toString(),
            message = message
        )

        // TODO defaultでcopyメソッドが用意されている
        return response.copy(message = "Hello, ${response.message}")
    }
}