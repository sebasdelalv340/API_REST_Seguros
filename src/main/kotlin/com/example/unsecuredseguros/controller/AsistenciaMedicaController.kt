package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.model.AsistenciaMedica
import com.example.unsecuredseguros.service.AsistenciaMedicaService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/asistencias")
class AsistenciaMedicaController {
    @Autowired
    private lateinit var asistenciaMedicaService: AsistenciaMedicaService

    @GetMapping("/{idAsistenciaMedica}")
    fun getById(@PathVariable idAsistenciaMedica: String?): ResponseEntity<AsistenciaMedica> {
        if (idAsistenciaMedica.isNullOrEmpty()) {
            if (idAsistenciaMedica!= null && idAsistenciaMedica.isEmpty()) {
                throw IllegalArgumentException("El id no puede estar vacío.")
            }
            throw EntityNotFoundException("El id no pertenece a ninguna asistencia médica.")
        }
        return ResponseEntity<AsistenciaMedica>(asistenciaMedicaService.getById(idAsistenciaMedica), HttpStatus.OK)
    }


    @GetMapping("/")
    fun list(): List<AsistenciaMedica?> {
        return asistenciaMedicaService.getAll()
    }


    @PostMapping("/")
    fun insert(@RequestBody asistencia: AsistenciaMedica?): AsistenciaMedica {
        if (asistencia == null) {
            throw IllegalArgumentException("La asistencia médica introducida no es correcta.")
        }
        return asistenciaMedicaService.insert(asistencia)
    }

    @PutMapping("/{idAsistenciaMedica}")
    fun update(@PathVariable idAsistenciaMedica: String?, @RequestBody asistencia: AsistenciaMedica?): AsistenciaMedica? {
        if (idAsistenciaMedica.isNullOrEmpty()) {
            throw IllegalArgumentException("El id no puede estar vacío.")
        }
        if(asistencia == null) {
            throw IllegalArgumentException("La asistencia médica introducida no es correcta.")
        }
        return asistenciaMedicaService.update(asistencia)
    }

    @DeleteMapping("/{idAsistenciaMedica}")
    fun delete(@PathVariable idAsistenciaMedica: String): Unit? {
        return if (idAsistenciaMedica.isEmpty()) {
            throw IllegalArgumentException("El id no puede estar vacío.")
        } else{
            asistenciaMedicaService.deleteById(idAsistenciaMedica.toLong())
        }
    }
}