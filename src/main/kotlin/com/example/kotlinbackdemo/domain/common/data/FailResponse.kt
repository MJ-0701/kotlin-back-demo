package com.example.kotlinbackdemo.domain.common.data

import com.example.kotlinbackdemo.global.Base.BaseResponse
import com.example.kotlinbackdemo.global.http.ErrorObject

data class FailResponse(
    val errorObject: ErrorObject
) {
    val responseCode: Int = 4000
}