package com.example.kotlinbackdemo.global.Base

interface BaseEntity<T> {
    fun <U> toDto(dto : BaseDto<T, U>) = dto.of(this as T)
}