package com.example.unsecuredseguros.exception

import jakarta.persistence.EntityNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.security.InvalidParameterException

@ControllerAdvice
class APIExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class, NumberFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBadRequest(request: HttpServletRequest, e: Exception): ErrorRespuesta {
        return ErrorRespuesta(e.message, request.requestURI)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFound(request: HttpServletRequest, e: NotFoundException): ErrorRespuesta {
        return ErrorRespuesta(e.message, request.requestURI)
    }

    @ExceptionHandler(InvalidParameterException::class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    fun handleInvalidParameter(request: HttpServletRequest, e: ValidationException): ErrorRespuesta {
        return ErrorRespuesta(e.message, request.requestURI)
    }
}