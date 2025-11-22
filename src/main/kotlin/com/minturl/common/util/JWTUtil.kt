package com.minturl.common.util

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import java.util.Date

class JWTUtil(
    @Value("\${jwt.secret}") private val SECRET: String,
    @Value("\${jwt.access_token_expiration_time}") private val ACCESS_TOKEN_EXPIRATION_TIME: Long,
    @Value("\${jwt.refresh_token_expiration_time}") private val REFRESH_TOKEN_EXPIRATION_TIME: Long
) {

    private val key = Keys.hmacShaKeyFor(SECRET.toByteArray())

    fun generateAccessToken(username: String): String {
        return generateToken(username, ACCESS_TOKEN_EXPIRATION_TIME)
    }

    fun generateRefreshToken(username: String): String {
        return generateToken(username, REFRESH_TOKEN_EXPIRATION_TIME)
    }

    fun generateToken(username: String, expirationTime: Long): String {
        val now = Date()
        val expiration = Date(now.time + expirationTime)

        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(key)
            .compact()
    }

}