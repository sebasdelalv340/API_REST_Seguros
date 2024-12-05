package com.example.unsecuredseguros.consola

class Consola {
    fun imprimir(texto: String, salto: Boolean) {
        if(salto) {
            println(texto)
        } else {
            print(texto)
        }
    }
}