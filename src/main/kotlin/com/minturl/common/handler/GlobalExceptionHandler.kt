package com.minturl.common.handler

import com.minturl.common.response.ApiResponse
import com.minturl.common.response.ErrorCode
import com.minturl.common.response.ResponseBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleTypeMismatch(ex: MethodArgumentTypeMismatchException): ResponseEntity<ApiResponse<Nothing?>> {
        return ResponseBuilder.error(
            HttpStatus.BAD_REQUEST,
            ErrorCode.INVALID_REQUEST.code,
            "${ex.name} 파라미터는 ${ex.requiredType} 타입이어야 합니다.")
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingParam(ex: MissingServletRequestParameterException): ResponseEntity<ApiResponse<Nothing?>> {
        return ResponseBuilder.error(
            HttpStatus.BAD_REQUEST,
            ErrorCode.INVALID_REQUEST.code,
            "${ex.parameterName} 파라미터가 누락되었습니다.")
    }

    @ExceptionHandler(MissingPathVariableException::class)
    fun handleMissingPath(ex: MissingPathVariableException): ResponseEntity<ApiResponse<Nothing?>> {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST.code, "${ex.variableName} 경로 변수가 존재하지 않습니다.");
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Nothing?>> {
        val firstError = ex.bindingResult.fieldErrors.firstOrNull()
        val errorMessage = firstError?.defaultMessage ?: "잘못된 요청 데이터이다."
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST.code, errorMessage)
    }

}
