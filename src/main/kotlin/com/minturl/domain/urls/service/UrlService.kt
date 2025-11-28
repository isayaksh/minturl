package com.minturl.domain.urls.service

import com.minturl.domain.urls.dto.RegisterUrlReqDto
import com.minturl.domain.urls.entity.Url
import com.minturl.domain.urls.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun register(username: String, registerUrlReqDto: RegisterUrlReqDto): String {

        val url = registerUrlReqDto.toEntity(username)
        val savedUrl = urlRepository.save<Url>(url)

        return "";
    }

}