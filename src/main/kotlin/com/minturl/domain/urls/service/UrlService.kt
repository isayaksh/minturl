package com.minturl.domain.urls.service

import com.minturl.domain.urls.dto.RegisterUrlReqDto
import com.minturl.domain.urls.dto.RegisterUrlResDto
import com.minturl.domain.urls.entity.Url
import com.minturl.domain.urls.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun register(username: String, registerUrlReqDto: RegisterUrlReqDto): RegisterUrlResDto {

        val url = registerUrlReqDto.toEntity(username)
        urlRepository.save<Url>(url)

        val mintUrl = "http://localhost:8080/$username/${registerUrlReqDto.alias}"

        return RegisterUrlResDto(mintUrl = mintUrl)
    }

    fun findOriginalUrl(username: String, alias: String): String {

        val url = urlRepository.findByUsernameAndAlias(username, alias)
            ?: throw IllegalArgumentException("URL not found")

        return url.originalUrl
    }

}