package com.example.unsecuredseguros.utils

object PriceValidator {
    fun priceValidator(price: Double?): Double {
        if (validPrice(price)) return String.format("%.2f", price).toDouble() else throw IllegalArgumentException("El formato del importe no es correcto.")
    }

    private fun validPrice(price: Double?): Boolean {
        if (price != null) {
            if (price < 0) {
                throw IllegalArgumentException("El campo importe debe ser mayor que 0.")
            }
            return true
        }
        return false
    }
}