package com.practica1.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    //RELACCION NM
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

        name = "localcliente",
        joinColumns = @JoinColumn(name = "idCliente"),          //aqui tengo primero q poner el id de la clase donde estoy
        inverseJoinColumns = @JoinColumn(name = "idLocal")

    )
    private List<Local> listaLocales;


    
    public Cliente( String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento,
            String telefono, Categoria categoria) {
        
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.categoria = categoria;
    }



    public Cliente() {
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



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public Categoria getCategoria() {
        return categoria;
    }



    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }



    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", categoria=" + categoria + "]";
    }



    public List<Local> getListaLocales() {
        return listaLocales;
    }



    public void setListaLocales(List<Local> listaLocales) {
        this.listaLocales = listaLocales;
    }










}


















































    
