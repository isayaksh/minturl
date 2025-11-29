package com.minturl.domain.urls.repository

import com.minturl.domain.urls.entity.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository: JpaRepository<Url, Long> {
    fun findByUsernameAndAlias(username: String, alias: String): Url?
}