package com.example.kotlinbackdemo.global.http

enum class ErrorObject(
    val errorCode: Int,
    val errorMessage: String,
    val errorDetailMessage: String,
) {

    NOT_EXIST_APP_INFO(500, "오류가 발생하였습니다.", "조회된 앱버전이 없습니다."),
    EMPTY_VALUE(440, "필수 파라미터가 존재하지 않습니다.", "필수 파라미터가 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR(500, "오류가 발생하였습니다.", "서버 오류 발생"),
    NOT_EXIST_PRD(500, "오류가 발생하였습니다.", "존재하지 않는 상품입니다."),
    NOT_EXIST_DATA(500, "오류가 발생하였습니다.", "존재하지 않는 데이터입니다."),
    NOT_EXIST_ORD(500, "오류가 발생하였습니다.", "존재하지 않는 주문입니다."),
    NOT_EXIST_VEHICLE(500, "오류가 발생하였습니다.", "존재하지 않는 차량입니다."),
    IS_DC_ORD_STAT(500, "오류가 발생하였습니다.", "배송완료 처리 된 주문입니다."),
    PAYMENT_NICE_REQUEST_FAILED(540, "NicePayment 결제가 실패하였습니다..", "NicePayment 결제 요청에 대한 결과값이 실패입니다"),
    POINT_GIVE_TEMP_POINT_NAN(540, "설정된 적립 포인트 금액이 없습니다.", "POINT_GIVE_TEMP 테이블에 저장할 entity의 필수 값이 없습니다."),
    PAYMENT_NICEPAYMENT_REQUEST_FAILED(500, "NicePayment 결제가 실패하였습니다..", "NicePayment 결제 요청에 대한 결과값이 실패입니다"),
}