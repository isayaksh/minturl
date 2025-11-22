package com.minturl.domain.users.controller

import com.minturl.common.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController : UserControllerSpec {

    override fun getUser(): ResponseEntity<ApiResponse<String>> {
        return ResponseEntity.ok(null)
    }

    override fun loginUser(): ResponseEntity<ApiResponse<String>> {
        return ResponseEntity.ok(null)
    }

    override fun logoutUser(): ResponseEntity<ApiResponse<String>> {
        return ResponseEntity.ok(null)
    }

}