package com.example.kotlinbackdemo.global.http

import com.example.kotlinbackdemo.global.Base.BaseResponsePopup

class SuccessResponse<T : BaseResponsePopup> (val data : T) {

    val responseCode: Int = 2000

    companion object {
        val empty: SuccessResponse<EmptyResponse> = SuccessResponse(EmptyResponse())
    }
}