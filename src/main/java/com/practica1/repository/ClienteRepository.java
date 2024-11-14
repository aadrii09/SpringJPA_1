package com.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica1.entity.Categoria;
import com.practica1.entity.Cliente;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>  {

    //1
    List<Cliente> findByCategoria(Categoria categoria);

    //2
    List<Cliente> findByFechaNacimientoBeforeAndCategoria(LocalDate mayor20,Categoria categoria);

    //4
    //el foundById ya esta default aunq no se vea

    
    //10
    Cliente findByApellido1(String apellido1);

        

}
