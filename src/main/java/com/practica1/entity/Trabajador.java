package com.practica1.entity;

import java.time.LocalDate;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private String cargo;
    
    //RELACCION 1N
    @ManyToOne
    @JoinColumn(name ="idLocal")//esto es para unirlo con la tabla local targetEntity
    private Local idLocal; //fk

    
    //este constructor sirve para crear un trabajador para asignarlo ya a un local
    public Trabajador(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String cargo,
            Local idLocal) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.idLocal = idLocal;
    }


    public Trabajador() {
    }

    //este constructor sirve para crear un trabajador sin local
    public Trabajador(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String cargo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido1() {
        return apellido1;
    }


    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getApellido2() {
        return apellido2;
    }


    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Local getIdLocal() {
        return idLocal;
    }


    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }



    

    @Override
    public String toString() {
        return "Trabajador [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", fechaNacimiento=" + fechaNacimiento + ", cargo=" + cargo  +  "]";
    }


   







































    
}
