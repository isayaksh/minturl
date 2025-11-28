package com.minturl.domain.urls.dto

import com.minturl.domain.urls.entity.Url
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class RegisterUrlReqDto(
    @field:NotBlank(message = "원본 URL은 필수 값이다.")
    @field:Size(max = 2048, message = "URL은 최대 2048자까지 허용된다.")
    @field:Pattern(
        regexp = "^(http|https)://.*$",
        message = "URL은 http:// 또는 https:// 로 시작해야 한다."
    )
    val originalUrl: String,

    @field:NotBlank(message = "alias는 필수 값이다.")
    @field:Size(max = 100, message = "alias는 최대 100자까지 허용된다.")
    @field:Pattern(
        regexp = "^[a-zA-Z0-9-_]+$",
        message = "alias는 영문/숫자/하이픈/언더바만 허용된다."
    )
    val alias: String
) {
    fun toEntity(username: String): Url {
        return Url.create(username = username, alias = alias, originalUrl = originalUrl)
    }
}
