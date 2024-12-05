package com.example.unsecuredseguros.exception

class NotFoundException(mensaje: String = "Seguro no encontrado."): Exception("Not found exception (404). $mensaje") {
}