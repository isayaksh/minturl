package com.minturl.domain.users.controller

import com.minturl.common.response.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "USERS API", description = "Users API interface")
@RequestMapping("/users")
interface UserControllerSpec {

    @Operation(summary = "User 조회", description = "User를 조회한다.")
    @GetMapping
    fun getUser(accessToken: String?): ResponseEntity<ApiResponse<String>>

    @Operation(summary = "User 로그인", description = "HTTP Only 쿠기 추가")
    @GetMapping("/login")
    fun loginUser(): ResponseEntity<ApiResponse<String>>

    @Operation(summary = "User 로그아웃", description = "HTTP Only 쿠기 제거")
    @GetMapping("/logout")
    fun logoutUser(): ResponseEntity<ApiResponse<String>>

}