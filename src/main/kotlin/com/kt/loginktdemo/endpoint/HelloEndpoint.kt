package com.kt.loginktdemo.endpoint

import com.kt.loginktdemo.business.SampleBusinessAPI
import com.kt.loginktdemo.endpoint.response.dto.GreetingResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("kts")
class HelloEndpoint(private val sampleBusinessAPI: SampleBusinessAPI) {


    @GetMapping("get")
    fun helloEndpoint(): GreetingResponse {

        val message = sampleBusinessAPI.find()

        return GreetingResponse(
            datetime = LocalDateTime.now().toString(),
            message = message
        )
    }
}