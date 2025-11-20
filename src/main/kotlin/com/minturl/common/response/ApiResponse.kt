package com.minturl.common.response

data class ApiResponse<T>(
    val code: String,
    val message: String,
    val data: T
)
