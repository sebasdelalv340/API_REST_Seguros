package com.example.unsecuredseguros.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "asistenciasMedicas")
data class AsistenciaMedica(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAsistenciaMedica: Int,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="Seguro")
    val seguro: Seguro?, // Relación con Seguro

    @Column(nullable = false)
    val breveDescripcion: String,

    @Column(nullable = false)
    val lugar: String,

    @Column(nullable = false)
    val explicacion: String,

    @Column(nullable = false)
    val tipoAsistencia: String,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    val fecha: LocalDate,

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    val hora: LocalTime,

    @Column(nullable = false)
    var importe: Double
) {

}
