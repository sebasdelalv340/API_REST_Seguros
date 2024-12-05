package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.repository.SeguroRepository
import com.example.unsecuredseguros.utils.SeguroValidador.validarDni
import com.example.unsecuredseguros.utils.SeguroValidador.validarEdad
import com.example.unsecuredseguros.utils.SeguroValidador.validarEmbarazada
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.InvalidParameterException

@Service
class SeguroService {

    @Autowired
    private lateinit var seguroRepository: SeguroRepository

    fun getById(id: String): Seguro? {
        return seguroRepository.getReferenceById(id.toLong())
    }

    fun getAll(): List<Seguro?> {
        return seguroRepository.findAll()
    }

    fun insert(seguro: Seguro): Seguro {
        if(!validarDni(seguro.nif)) {
            throw IllegalArgumentException("El campo NIF no tiene un formato válido.")
        }
        if (!validarEmbarazada(seguro)) {
            throw IllegalArgumentException("El campo embarazada no puede ser true si el asegurado es hombre.")
        }
        if (!validarEdad(seguro.edad)) {
            throw IllegalArgumentException("No es posible ser menor de edad para hacer un seguro.")
        }
        return seguroRepository.save(seguro)
    }

    fun update(seguro: Seguro?): Seguro? {
        if(seguro != null) {
            return seguroRepository.save(seguro)
        }
        return null
    }

    fun deleteById(id: Long) {
        return seguroRepository.deleteById(id)
    }


}