package com.minturl.domain.users.controller

import com.minturl.common.constvalue.ConstValue
import com.minturl.common.response.ApiResponse
import com.minturl.common.response.ResponseBuilder
import com.minturl.common.util.CookieUtil
import com.minturl.common.util.JWTUtil
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(
    private val jwtUtil: JWTUtil,
    private val cookieUtil: CookieUtil
) : UserControllerSpec {

    override fun getUser(
        @CookieValue(name = ConstValue.COOKIE.ACCESS_TOKEN_NAME, required = false) accessToken: String?
    ): ResponseEntity<ApiResponse<String>> {
        if (accessToken == null) {
            return ResponseBuilder.ok("쿠키 없음.")
        }

        return ResponseBuilder.ok("쿠키 있음.")
    }

    override fun loginUser(): ResponseEntity<ApiResponse<String>> {

        val accessToken = jwtUtil.generateAccessToken("username")
        val refreshToken = jwtUtil.generateRefreshToken("username")

        val accessCookie = cookieUtil.createAccessTokenCookie(accessToken)
        val refreshCookie = cookieUtil.createRefreshTokenCookie(refreshToken)

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, accessCookie)
            .header(HttpHeaders.SET_COOKIE, refreshCookie)
            .body(null)
    }

    override fun logoutUser(): ResponseEntity<ApiResponse<String>> {

        val clearAccessCookie = cookieUtil.clearRefreshTokenCookie()
        val clearRefreshCookie = cookieUtil.clearAccessTokenCookie()

        return ResponseEntity.ok()
            .header(HttpHeaders.SET_COOKIE, clearAccessCookie)
            .header(HttpHeaders.SET_COOKIE, clearRefreshCookie)
            .body(null)
    }

}