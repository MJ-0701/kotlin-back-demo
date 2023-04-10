package com.example.kotlinbackdemo.global.http

import com.example.kotlinbackdemo.global.Base.BaseEnum
import com.fasterxml.jackson.annotation.JsonCreator

enum class ResponseStatus(
    code : Int,
    val title: String
) : BaseEnum<Int> {

    SUCCESS(2000, "성공"),
    USER_FAIL(4000, "사용자 실패"),
    SYSTEM_FAIL(5000, "시스템 실패");

    override val value = code;

    companion object{
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        @JvmStatic
        fun valueOf(value : Int) = BaseEnum.valueOf(value, values())
    }

}