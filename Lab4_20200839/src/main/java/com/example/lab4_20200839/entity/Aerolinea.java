package com.example.lab4_20200839.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aerolinea")
public class Aerolinea {
    @Id
    @Column(name = "idaerolinea", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;

}