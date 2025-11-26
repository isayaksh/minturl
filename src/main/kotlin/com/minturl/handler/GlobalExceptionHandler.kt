package com.minturl.handler

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
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingParam(ex: MissingServletRequestParameterException): ResponseEntity<ApiResponse<Nothing?>> {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST);
    }

    @ExceptionHandler(MissingPathVariableException::class)
    fun handleMissingPath(ex: MissingPathVariableException): ResponseEntity<ApiResponse<Nothing?>> {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST);
    }

    

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Nothing?>> {
        val firstError = ex.bindingResult.fieldErrors.firstOrNull()
        val errorMessage = firstError?.defaultMessage ?: "잘못된 요청 데이터이다."
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_REQUEST.code, errorMessage)
    }

}
