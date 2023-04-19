package com.example.lab4_20200839.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "idreserva", nullable = false)
    private Integer id;

    @Column(name = "fecha_reserva", nullable = false)
    private Instant fechaReserva;

    @Column(name = "precio_total", nullable = false, precision = 10)
    private BigDecimal precioTotal;

    @Column(name = "estado_pago", nullable = false, length = 45)
    private String estadoPago;

}