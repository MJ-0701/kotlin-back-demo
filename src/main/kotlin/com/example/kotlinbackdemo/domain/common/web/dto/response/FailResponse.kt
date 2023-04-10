package com.example.kotlinbackdemo.domain.common.web.dto.response

import com.example.kotlinbackdemo.global.Base.BaseResponse
import com.example.kotlinbackdemo.global.http.ErrorObject

data class FailResponse(
    val errorObject: ErrorObject
) {
    val responseCode: Int = 4000
}