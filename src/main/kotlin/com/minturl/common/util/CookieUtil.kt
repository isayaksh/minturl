package com.minturl.common.util

import com.minturl.common.constvalue.ConstValue
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Component

@Component
class CookieUtil(
    @Value("\${cookie.secure}") private val secure: Boolean,
) {

    // Access Token Cookie 생성
    fun createAccessTokenCookie(
        token: String
    ): String {
        return createCookie(ConstValue.COOKIE.ACCESS_TOKEN_NAME, token, ConstValue.COOKIE.ACCESS_TOKEN_EXPIRATION)
    }

    // Refresh Token Cookie 생성
    fun createRefreshTokenCookie(
        token: String
    ): String {
        return createCookie(ConstValue.COOKIE.REFRESH_TOKEN_NAME, token, ConstValue.COOKIE.REFRESH_TOKEN_EXPIRATION)
    }

    // Access Token Cookie 제거
    fun clearAccessTokenCookie(): String {
        return createCookie(ConstValue.COOKIE.ACCESS_TOKEN_NAME, "", 0)
    }

    // Refresh Token Cookie 제거
    fun clearRefreshTokenCookie(): String {
        return createCookie(ConstValue.COOKIE.REFRESH_TOKEN_NAME, "", 0)
    }

    private fun createCookie(name: String, token: String, expiration: Long): String {
        return ResponseCookie.from(name, token)
            .httpOnly(true)
            .secure(secure)
            .sameSite("Strict")
            .path("/")
            .maxAge(expiration)
            .build()
            .toString()
    }

}