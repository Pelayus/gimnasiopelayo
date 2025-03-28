package com.gimnasio.gimnasiopelayo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(nullable = false, unique = true, length = 9)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    private String tipo;

    private int sesiones;

    private LocalDate fechaAlta;

    private LocalDate fechaNacimiento;

    private double peso;

    private int altura;

    private String email;

    public Cliente(String dni, String nombre, String apellidos, String tipo, int sesiones, LocalDate fechaAlta, LocalDate fechaNacimiento, double peso, int altura, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.sesiones = sesiones;
        this.fechaAlta = fechaAlta;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
    }
}
