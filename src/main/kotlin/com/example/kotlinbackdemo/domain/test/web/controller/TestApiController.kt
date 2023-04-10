package com.example.kotlinbackdemo.domain.test.web.controller

import com.example.kotlinbackdemo.domain.test.service.TestService
import com.example.kotlinbackdemo.domain.test.web.dto.response.TestResponseDto
import com.example.kotlinbackdemo.global.http.SuccessResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/test")
@RestController
class TestApiController(
    val testService : TestService
) {

    @GetMapping("")
    private fun apiTest() : ResponseEntity<SuccessResponse<TestResponseDto.TestCaseDto>> {
        TestResponseDto.TestCaseDto(
            contents = "내용1",
            text = "내용2"
        ).let { return ResponseEntity.ok().body(SuccessResponse(it)) }
    }
}