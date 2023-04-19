package com.example.lab4_20200839.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @Column(name = "idvuelo", nullable = false)
    private Integer id;

    @Column(name = "origen", nullable = false, length = 45)
    private String origen;

    @Column(name = "destino", nullable = false, length = 45)
    private String destino;

    @Column(name = "fecha_salida", nullable = false)
    private Instant fechaSalida;

    @Column(name = "fecha_llegada", nullable = false)
    private Instant fechaLlegada;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "precio", nullable = false, precision = 10)
    private BigDecimal precio;

    @Column(name = "asientos_disponibles", nullable = false)
    private Integer asientosDisponibles;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aerolinea_idaerolinea", nullable = false)
    private Aerolinea aerolineaIdaerolinea;

}