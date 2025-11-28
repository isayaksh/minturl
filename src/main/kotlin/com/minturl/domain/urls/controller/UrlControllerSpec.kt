package com.minturl.domain.urls.controller

import com.minturl.common.constvalue.ConstValue
import com.minturl.common.response.ApiResponse
import com.minturl.domain.urls.dto.RegisterUrlReqDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "URL API", description = "URL API interface")
@RequestMapping("/urls")
interface UrlControllerSpec {

    @Operation(summary = "URL 등록", description = "Shorten URL을 등록한다.")
    @PostMapping
    fun registerUrl(@CookieValue(name = ConstValue.COOKIE.ACCESS_TOKEN_NAME, required = false) accessToken: String?,
                    @Valid @RequestBody registerUrlReqDto: RegisterUrlReqDto): ResponseEntity<ApiResponse<String>>

    @Operation(summary = "URL 조회", description = "Shorten URL에 매핑된 실제 URL로 redirection")
    @GetMapping("/{userName}")
    fun getUrls(@PathVariable userName: String): ResponseEntity<ApiResponse<String>>

    @Operation(summary = "URL 조회", description = "Shorten URL에 매핑된 실제 URL로 redirection")
    @GetMapping("/{userName}/{shortenUrl}")
    fun redirectUrl(@PathVariable userName: String, @PathVariable shortenUrl: String): ResponseEntity<ApiResponse<String>>

}