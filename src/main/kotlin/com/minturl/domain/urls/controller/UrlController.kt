package com.minturl.domain.urls.controller

import com.minturl.common.response.ApiResponse
import com.minturl.common.response.ResponseBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController: UrlControllerSpec {
    override fun registerUrl(): ResponseEntity<ApiResponse<String>> {
        return ResponseBuilder.ok("")
    }

    override fun redirectUrl(userName: String, shortenUrl: String): ResponseEntity<ApiResponse<String>> {
        return ResponseBuilder.ok(userName + ", " + shortenUrl)
    }
}