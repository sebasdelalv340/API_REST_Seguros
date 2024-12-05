package com.example.unsecuredseguros.model

import jakarta.persistence.*
import java.sql.Timestamp
import java.time.Instant

@Entity
@Table(name="seguros")
data class Seguro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idSeguro: Int,

    @Column(nullable = false, length = 10)
    val nif: String,

    @Column(nullable = false, length = 100)
    val nombre: String,

    @Column(nullable = false, length = 100)
    val ape1: String,

    @Column(nullable = false, length = 100)
    val ape2: String?,

    @Column(nullable = false)
    val edad: Int,

    @Column(nullable = false)
    val numHijos: Int,

    @Column(name= "fecha_creacion",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val fechaCreacion: Timestamp = Timestamp.from(Instant.now()),

    @Column(nullable = false, length = 10)
    val sexo: String,

    @Column(nullable = false)
    val casado: Boolean,

    @Column(nullable = false)
    val embarazada: Boolean
)