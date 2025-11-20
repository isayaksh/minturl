package com.minturl.common.response

enum class ErrorCode(
    val code: String,
    val message: String
) {
    INVALID_REQUEST("ERROR001", "유효하지 않은 요청입니다.")
}