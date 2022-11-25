package com.delington.bjorg.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @RequestMapping("/")
    fun index(): String {
        val o = alma()
        return "Greetings from Spring Boot!"
    }

    fun alma(): Map<String, Int> {
        val lak = "d"
        val ds: Int = 0

        return mapOf(lak to ds)
    }
}
