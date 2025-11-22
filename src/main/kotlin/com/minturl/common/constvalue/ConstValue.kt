package com.minturl.common.constvalue

object ConstValue {

    object JWT {
        const val ACCESS_TOKEN_EXPIRATION  = 1000L * 60 * 60          // 1 hour
        const val REFRESH_TOKEN_EXPIRATION = 1000L * 60 * 60 * 24 * 7 // 7 days
    }

    object COOKIE {
        const val ACCESS_TOKEN_NAME  = "access_token"
        const val REFRESH_TOKEN_NAME = "refresh_token"
        const val ACCESS_TOKEN_EXPIRATION  = 1L * 60 * 60          // 1 hour
        const val REFRESH_TOKEN_EXPIRATION = 1L * 60 * 60 * 24 * 7 // 7 days
    }

}