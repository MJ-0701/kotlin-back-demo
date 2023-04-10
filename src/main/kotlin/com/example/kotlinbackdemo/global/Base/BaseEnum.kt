package com.example.kotlinbackdemo.global.Base

interface BaseEnum<U> {
    val value : U

    companion object {
        fun<T,U> valueOf(value : T, values : Array<U>) where U : Enum<U>, U : BaseEnum<T> = values.first {
            it.value == value
        }
    }
}