package com.minturl.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.net.URI

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

    fun error(status: HttpStatus, code: String, message: String): ResponseEntity<ApiResponse<Nothing?>> =
        ResponseEntity(
            ApiResponse(
                code = code,
                message = message,
                data = null
            ),
            status
        )

    fun redirect(originalUrl: String): ResponseEntity<Void> =
        ResponseEntity
            .status(HttpStatus.FOUND)
            .location(URI.create(originalUrl))
            .build();

}