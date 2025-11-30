package com.minturl.domain.urls.controller

import com.minturl.common.response.ApiResponse
import com.minturl.common.response.ResponseBuilder
import com.minturl.common.util.JWTUtil
import com.minturl.domain.urls.dto.RegisterUrlReqDto
import com.minturl.domain.urls.dto.RegisterUrlResDto
import com.minturl.domain.urls.service.UrlService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class UrlController(
    val urlService: UrlService,
    val jwtUtil: JWTUtil
): UrlControllerSpec {
    override fun registerUrl(accessToken: String?, registerUrlReqDto: RegisterUrlReqDto): ResponseEntity<ApiResponse<RegisterUrlResDto>> {

        val username = jwtUtil.extractUsername(accessToken ?: throw IllegalArgumentException(""))

        val registerUrlResDto = urlService.register(username, registerUrlReqDto)

        return ResponseBuilder.ok(registerUrlResDto);
    }

    override fun getUrls(userName: String): ResponseEntity<ApiResponse<String>> {
        return ResponseBuilder.ok("")
    }

    override fun redirectUrl(username: String, alias: String): ResponseEntity<Void> {

        val originalUrl = urlService.findOriginalUrl(username, alias)

        return ResponseBuilder.redirect(originalUrl)
    }
}