/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drk.main.clases;

/**
 *
 * @author drk
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    
    public Persona(String nombre, String apellido,String cedula, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }
    
    public String getNombre(){
        System.out.println("Nombre: "+this.nombre);
        return this.nombre;
    }
    
    public String getApellido(){
        System.out.println("Apellido: "+this.apellido);
        return this.apellido;
    }
    
    public String getCedula(){
        System.out.println("Cedula: "+this.cedula);
        return this.cedula;
    }
    
    public int getEdad(){
        System.out.println("Edad: "+this.edad);
        return this.edad;
    }
    
}
