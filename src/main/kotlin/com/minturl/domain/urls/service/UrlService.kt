package com.minturl.domain.urls.service

import com.minturl.domain.urls.dto.RegisterUrlDto
import com.minturl.domain.urls.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class UrlService(
    urlRepository: UrlRepository
) {

    fun register(username: String, registerUrlDto: RegisterUrlDto): String {



        return "";
    }

}