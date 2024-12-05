package com.example.unsecuredseguros.controller

import com.example.unsecuredseguros.model.Seguro
import com.example.unsecuredseguros.service.SeguroService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/seguros")
class SeguroController {

    @Autowired
    private lateinit var seguroService: SeguroService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String?): ResponseEntity<Seguro> {
        if (id.isNullOrEmpty()) {
            if (id != null && id.isEmpty()) {
                throw IllegalArgumentException("El id no puede estar vacío.")
            }
            throw EntityNotFoundException("El id no pertenece a ningún seguro.")
        }
        return ResponseEntity<Seguro>(seguroService.getById(id), HttpStatus.OK)
    }


    @GetMapping("/")
    fun list(): List<Seguro?> {
        return seguroService.getAll()
    }


    @PostMapping("/")
    fun insert(@RequestBody seguro: Seguro?): Seguro {
        if (seguro == null) {
            throw IllegalArgumentException("El seguro introducido no es correcto.")
        }
        return seguroService.insert(seguro)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String?, @RequestBody seguro: Seguro?): Seguro? {
        if (id.isNullOrEmpty()) {
            throw IllegalArgumentException("El id no puede estar vacío.")
        }
        if(seguro == null) {
            throw IllegalArgumentException("El seguro introducido no es correcto.")
        }
        return seguroService.update(seguro)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Unit? {
        return if (id.isEmpty()) {
            throw IllegalArgumentException("El id no puede estar vacío.")
        } else{
            seguroService.deleteById(id.toLong())
        }
    }
}