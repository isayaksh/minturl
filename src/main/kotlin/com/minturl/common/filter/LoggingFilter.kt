package com.minturl.common.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper

@Component
class LoggingFilter: OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val reqWrapper = ContentCachingRequestWrapper(request)
        val resWrapper = ContentCachingResponseWrapper(response)

        filterChain.doFilter(reqWrapper, resWrapper)

        resWrapper.copyBodyToResponse() // response body 복구
    }
}