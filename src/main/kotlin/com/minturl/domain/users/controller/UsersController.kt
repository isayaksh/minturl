package com.minturl.domain.users.controller

import com.minturl.common.dto.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

    @GetMapping()
    fun getUsers(): ResponseEntity<ApiResponse<String>> {
        return ResponseEntity.ok(null)
    }

}