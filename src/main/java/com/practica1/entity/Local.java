package com.practica1.entity;


import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//mapped by usamos la lista y en el resto por el nombre de la columna
    @Entity
    @Table(name = "locales")
    public class Local {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nombre;
        private int aforoMax;
        private float metrosCuadrados;
        // RELACCION 1N bidireccional
        @OneToMany(mappedBy = "idLocal", fetch =  FetchType.EAGER) //siempre q use el OneToMany tendo q usar el mappedBy e igualarlo a la columna 1N creada
        private List<Trabajador> listaTrabajadores;

        //PARA Q SEA BIDIRECCIONAL la nm
        //aqui seria ManyToOne?
        @ManyToMany(mappedBy = "listaLocales",fetch = FetchType.EAGER) //siempre q use el ManyToMany tendo q usar el mappedBy e igualarlo a la lista de locales q cree en cliente
        private List<Cliente> listaClientes;

    

        public Local(String nombre, int aforoMax, float metrosCuadrados) {
            
            this.nombre = nombre;
            this.aforoMax = aforoMax;
            this.metrosCuadrados = metrosCuadrados;
        }
    
    
    
        public Local() {
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
    
    
    
        public int getAforoMax() {
            return aforoMax;
        }
    
    
    
        public void setAforoMax(int aforoMax) {
            this.aforoMax = aforoMax;
        }
    
    
    
        public float getMetrosCuadrados() {
            return metrosCuadrados;
        }
    
    
    
        public void setMetrosCuadrados(float metrosCuadrados) {
            this.metrosCuadrados = metrosCuadrados;
        }
    
    
    
        @Override
        public String toString() {
            return "local [id=" + id + ", nombre=" + nombre + ", aforoMax=" + aforoMax + ", metrosCuadrados="
                    + metrosCuadrados + "]";
        }
        
    
        public List<Trabajador> getListaTrabajadores() {
            return listaTrabajadores;
        }



        public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
            this.listaTrabajadores = listaTrabajadores;
        }



        public List<Cliente> getListaClientes() {
            return listaClientes;
        }



        public void setListaClientes(List<Cliente> listaClientes) {
            this.listaClientes = listaClientes;
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    }
    

