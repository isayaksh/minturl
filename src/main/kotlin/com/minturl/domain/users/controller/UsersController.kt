package com.minturl.domain.users.controller

import com.minturl.common.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController : UserControllerSpec {

    override fun getUsers(): ResponseEntity<ApiResponse<String>> {
        return ResponseEntity.ok(null)
    }

}