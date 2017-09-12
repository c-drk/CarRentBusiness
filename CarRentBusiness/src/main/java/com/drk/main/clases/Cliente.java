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
public class Cliente extends Persona{
    private boolean adulto;
    private boolean membresia;

    public Cliente(String nombre, String apellido, String cedula, int edad, boolean membresia) {
        super(nombre, apellido, cedula, edad);
        this.adulto = (edad>17);
        this.membresia=membresia;        
    }
    
    public boolean esAdulto(){
        System.out.println("Es adulto?: "+this.adulto);
        return this.adulto;
    }
    
    public boolean esMiembro(){
        System.out.println("Es miembro?: "+this.membresia);
        return this.membresia;
    }
    
}
