package com.example.kotlinbackdemo.global.Base

import com.example.kotlinbackdemo.global.http.ResponseStatus

interface BaseResponse {

    val responseCode: ResponseStatus?
    val errorObject: ErrorObject?

    class ErrorObject(
        val errorCode: Int,
        val errorMessage: String,
        val errorDetailMessage: String,
        val nextTimeBlock: String,
    )
}