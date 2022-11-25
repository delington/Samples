package com.delington.bjorg.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HelloControllerTest {

    private val controller = HelloController()

    @Test
    fun `test alma`() {
        val result = controller.alma()

        Assertions.assertEquals(0, result["d"])
    }
}
