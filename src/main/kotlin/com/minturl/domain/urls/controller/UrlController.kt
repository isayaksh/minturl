package com.minturl.domain.urls.controller

import com.minturl.common.response.ApiResponse
import com.minturl.common.response.ResponseBuilder
import com.minturl.common.util.JWTUtil
import com.minturl.domain.urls.dto.RegisterUrlReqDto
import com.minturl.domain.urls.service.UrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController(
    val urlService: UrlService,
    val jwtUtil: JWTUtil
): UrlControllerSpec {
    override fun registerUrl(accessToken: String?, registerUrlReqDto: RegisterUrlReqDto): ResponseEntity<ApiResponse<String>> {

        val username = jwtUtil.extractUsername(accessToken ?: throw IllegalArgumentException(""))

        urlService.register(username, registerUrlReqDto);

        return ResponseBuilder.ok("")
    }

    override fun getUrls(userName: String): ResponseEntity<ApiResponse<String>> {
        return ResponseBuilder.ok("")
    }

    override fun redirectUrl(userName: String, shortenUrl: String): ResponseEntity<ApiResponse<String>> {
        return ResponseBuilder.ok(userName + ", " + shortenUrl)
    }
}