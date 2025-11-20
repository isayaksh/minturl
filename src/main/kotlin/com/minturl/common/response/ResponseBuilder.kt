package com.minturl.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object ResponseBuilder {

    fun <T> ok(data: T): ResponseEntity<ApiResponse<T>> =
        ResponseEntity(
            ApiResponse(
                code = "200",
                message = "ok",
                data = data
            ),
            HttpStatus.OK
        )

    fun error(status: HttpStatus, errorCode: ErrorCode): ResponseEntity<ApiResponse<Nothing?>> =
        ResponseEntity(
            ApiResponse(
                code = errorCode.code,
                message = errorCode.message,
                data = null
            ),
            status
        )
}