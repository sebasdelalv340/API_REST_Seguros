package com.example.unsecuredseguros.utils

import com.example.unsecuredseguros.model.Seguro

object SeguroValidador {
    fun validarDni(dni: String): Boolean {
        val regex = """^\d{8}[A-Za-z]$""".toRegex()
        if (!dni.matches(regex)) {
            return false
        }

        val numeroDNI = dni.substring(0, 8).toInt()

        val letraDNI = dni.last().uppercase()

        val letras = "TRWAGMYFPDXBNJZSQVHLCKE"

        val letraCalculada = letras[numeroDNI % 23].toString()

        return letraDNI == letraCalculada
    }

    fun validarEmbarazada(seguro: Seguro): Boolean {
        return seguro.embarazada && seguro.sexo.lowercase() == "mujer"
    }

    fun validarEdad(edad: Int): Boolean {
        return edad >= 18
    }

    fun validarHijos(numHijos: Int): Boolean {
        return numHijos >= 0
    }
}