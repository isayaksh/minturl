package com.minturl.config

import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class AuditConfig : AuditorAware<Long> {
    override fun getCurrentAuditor(): Optional<Long> {
        return Optional.of(0L)
    }
}