package com.example.unsecuredseguros.exception

class ValidationException(mensaje: String): Exception("Error en la validación (400). $mensaje") {


}