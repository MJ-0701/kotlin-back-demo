package com.example.kotlinbackdemo.global.http

import com.example.kotlinbackdemo.domain.common.web.CommonException
import com.example.kotlinbackdemo.domain.common.web.dto.response.FailResponse
import com.example.kotlinbackdemo.global.utils.Logging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(annotations = [RestController::class])
class RestExceptionHandler {

    companion object : Logging

    @ExceptionHandler(CommonException::class)
    protected fun handleCommonException(ex: CommonException): ResponseEntity<FailResponse> {
        logger.error("Common Exception {}", ex.errorHint, ex)
        return handle(HttpStatus.INTERNAL_SERVER_ERROR, ex.failResponse)
    }

    @ExceptionHandler(RuntimeException::class)
    protected fun handleRuntimeException(ex: RuntimeException?): ResponseEntity<FailResponse> {
        logger.error("Runtime Exception", ex)
        return handle(HttpStatus.INTERNAL_SERVER_ERROR, FailResponse(ErrorObject.INTERNAL_SERVER_ERROR))
    }

    @ExceptionHandler(Exception::class)
    protected fun handleException(ex: Exception?): ResponseEntity<FailResponse> {
        logger.error("Exception", ex)
        return handle(HttpStatus.INTERNAL_SERVER_ERROR, FailResponse(ErrorObject.INTERNAL_SERVER_ERROR))
    }

    private fun handle(httpStatus: HttpStatus, failResponse: FailResponse): ResponseEntity<FailResponse> {
        return ResponseEntity
            .status(httpStatus)
            .headers(HttpHeaders())
            .body(failResponse)
    }
}