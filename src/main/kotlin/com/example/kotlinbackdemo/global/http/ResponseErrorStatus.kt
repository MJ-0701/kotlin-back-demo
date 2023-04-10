package com.example.kotlinbackdemo.global.http

import com.example.kotlinbackdemo.global.Base.BaseEnum

enum class ResponseErrorStatus(
    code: Int,
    val title: String
) : BaseEnum<Int> {

    CLIENT(440, "사용자 정의 오류"),
    SERVER(540, "시스템 오류");

    override val value: Int = code

}