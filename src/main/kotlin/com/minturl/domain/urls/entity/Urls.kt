package com.minturl.domain.urls.entity

import com.minturl.common.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "urls",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_username_alias",
            columnNames = ["username", "alias"]
        )
    ])
class Urls(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,

    @Column(name = "username", nullable = false, length = 50)
    val username: String,

    @Column(name = "alias", nullable = false, length = 100)
    val alias: String,

    @Column(name = "originalUrl", nullable = false, length = 2048)
    val originalUrl: String,

): BaseEntity()