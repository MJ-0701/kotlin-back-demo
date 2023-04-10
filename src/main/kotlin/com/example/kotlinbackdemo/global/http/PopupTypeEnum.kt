package com.example.kotlinbackdemo.global.http

import com.example.kotlinbackdemo.global.Base.BaseEnum

enum class PopupTypeEnum(val description: String) : BaseEnum<PopupTypeEnum> {

    NONE("메시지 기능을 쓰지 않는다"),
    ALERT("확인 창이 뜨는 메시지"),
    TOAST("하단에 몇 초간 떠 있는 메시지");

    override val value: PopupTypeEnum = this

}