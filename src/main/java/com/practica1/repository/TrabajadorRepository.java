package com.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica1.entity.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {

    //6
    Trabajador findByNombre(String nombre);

}

