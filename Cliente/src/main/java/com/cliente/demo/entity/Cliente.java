package com.cliente.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;

    @Column(name = "email", nullable = true, length = 100)
    private String email;
    
    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;

    @Column(name = "direccion", nullable = true, length = 200)
    private String direccion;

 
}