package com.minturl.common.interceptor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.swagger.v3.core.util.Json.mapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.lang.Exception

@Component
class HttpLoggingInterceptor: HandlerInterceptor {

    private val log = LoggerFactory.getLogger(javaClass)
    private val mapper = ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val req = request as ContentCachingRequestWrapper
        val res = response as ContentCachingResponseWrapper

        val requestBody = String(req.contentAsByteArray, Charsets.UTF_8)
        val responseBody = String(res.contentAsByteArray, Charsets.UTF_8)

        val jsonLog = mapOf(
            "method" to request.method,
            "url" to request.requestURI,
            "query" to (request.queryString ?: ""),
            "status" to response.status.toString(),
            "request" to jsonOrRaw(requestBody),
            "response" to jsonOrRaw(responseBody),
        )

        log.info("\n{}", mapper.writeValueAsString(jsonLog))
    }

    private fun jsonOrRaw(body: String): Any =
        try { mapper.readValue(body, Any::class.java) }
        catch (_: Exception) { body }

}