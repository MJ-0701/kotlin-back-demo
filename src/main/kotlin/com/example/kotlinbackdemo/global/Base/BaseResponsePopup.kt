package com.example.kotlinbackdemo.global.Base

import com.example.kotlinbackdemo.global.http.PopupTypeEnum
import io.swagger.v3.oas.annotations.media.Schema

abstract class BaseResponsePopup(

    @Schema(description = "팝업 데이터", required = true)
    var popData: PopupMessage = PopupMessage(PopupTypeEnum.NONE, "", ""),
) {

    data class PopupMessage(
        @Schema(
            description = "팝업 표시 여부(NONE : 사용안함, TOAST : 토스트 메시지, ALERT : 확인 창이 있는 메시지)",
            example = "NONE",
            required = true
        )
        val popType: PopupTypeEnum,
        @Schema(description = "팝업 제목", example = "인증 번호 요청 실패", required = true)
        val popTit: String,
        @Schema(description = "팝업 내용", example = "인증 데이터 오류", required = true)
        var popCntn: String,
    )
}