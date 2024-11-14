package com.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica1.entity.Local;
import java.util.List;


public interface LocalRepository extends JpaRepository<Local,Integer> {

    //3
    List<Local> findByAforoMaxBetween(int aforo20, int aforo100);
    

    //5
    Local findByNombre(String nombre);
}
