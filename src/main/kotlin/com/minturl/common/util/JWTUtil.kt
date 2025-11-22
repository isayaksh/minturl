package com.minturl.common.util

import com.minturl.common.constvalue.ConstValue
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JWTUtil(
    @Value("\${jwt.secret}") private val SECRET: String
) {

    private val key = Keys.hmacShaKeyFor(SECRET.toByteArray())

    fun generateAccessToken(username: String): String {
        return generateToken(username, ConstValue.JWT.ACCESS_TOKEN_EXPIRATION)
    }

    fun generateRefreshToken(username: String): String {
        return generateToken(username, ConstValue.JWT.REFRESH_TOKEN_EXPIRATION)
    }

    private fun generateToken(username: String, expirationTime: Long): String {
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