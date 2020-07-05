package com.nami.backend.common.util

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDate

@ControllerAdvice
public class SomeExceptionHandler : ResponseEntityExceptionHandler()
{
    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val body = mutableMapOf<String, Any>()
        body["timestamp"] = LocalDate.now()
        body["status"] = status.value()
        body["errors"] = ex.bindingResult.fieldErrors.map { it.defaultMessage }
        return ResponseEntity(body, status)
    }
}