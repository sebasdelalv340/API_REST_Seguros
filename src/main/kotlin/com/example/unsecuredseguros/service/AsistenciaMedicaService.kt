package com.example.unsecuredseguros.service

import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.repository.AsistenciaMedicaRepository
import com.example.unsecuredseguros.utils.PriceValidator.priceValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AsistenciaMedicaService {


    @Autowired
    private lateinit var asistenciaMedicaRepository: AsistenciaMedicaRepository

    fun getById(id: String): AsistenciaMedica? {
        return asistenciaMedicaRepository.getReferenceById(id.toLong())
    }

    fun getAll(): List<AsistenciaMedica?> {
        return asistenciaMedicaRepository.findAll()
    }

    fun insert(asistencia: AsistenciaMedica): AsistenciaMedica {
        asistencia.importe = priceValidator(asistencia.importe)
        return asistenciaMedicaRepository.save(asistencia)
    }

    fun update(asistencia: AsistenciaMedica?): AsistenciaMedica? {
        if(asistencia != null) {
            return asistenciaMedicaRepository.save(asistencia)
        }
        return null
    }

    fun deleteById(id: Long) {
        return asistenciaMedicaRepository.deleteById(id)
    }
}