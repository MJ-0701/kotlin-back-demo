package com.example.kotlinbackdemo.global.Base

interface BaseDto<T,U> {
    fun of(entity: T): U
}