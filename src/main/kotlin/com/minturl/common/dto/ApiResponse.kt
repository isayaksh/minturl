package com.minturl.common.dto

data class ApiResponse<T>(
    val code: String,
    val message: String,
    val data: T
)
