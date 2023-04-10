package com.example.kotlinbackdemo.domain.common.web

import com.example.kotlinbackdemo.domain.common.web.dto.response.FailResponse
import com.example.kotlinbackdemo.global.http.ErrorObject

class CommonException(
    val failResponse: FailResponse,
    val errorHint: String? = null,
    override val cause: Throwable?,
) : RuntimeException(failResponse.errorObject.errorMessage, cause) {
    constructor(
        errorObject: ErrorObject,
        errorHint: String? = null,
        cause: Throwable? = null,
    ) : this(
        failResponse = FailResponse(errorObject),
        errorHint = errorHint,
        cause = cause,
    )
}