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
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "urls",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_username_alias",
            columnNames = ["username", "alias"]
        )
    ])
class Url(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(name = "username", nullable = false, length = 50)
    val username: String,

    @Column(name = "alias", nullable = false, length = 100)
    val alias: String,

    @Column(name = "originalUrl", nullable = false, length = 2048)
    val originalUrl: String,

): BaseEntity() {

    companion object {
        fun create(username: String, alias: String, originalUrl: String): Url {
            return Url(
                id = null,
                username = username,
                alias = alias,
                originalUrl = originalUrl
            )
        }
    }

}