package com.example.kotlinbackdemo.domain.test.web.dto.response

import com.example.kotlinbackdemo.global.Base.BaseResponsePopup

object TestResponseDto {

    data class TestCaseDto(
        val contents: String,
        val text : String
    ) : BaseResponsePopup()

}