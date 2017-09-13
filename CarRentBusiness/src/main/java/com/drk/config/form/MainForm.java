/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drk.config.form;

/**
 *
 * @author drk
 */
public class MainForm{
    
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private boolean membresia;
    private String dataCar;
    private String fechaI;
    private String fechaF;
     
    public MainForm(String nombre, String apellido,String cedula, int edad, boolean membresia, String dataCar, String fechaI, String fechaF){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.edad=edad;
        this.membresia=membresia;
        this.dataCar=dataCar;
        this.fechaI=fechaI;
        this.fechaF=fechaF;
    }
    
    public MainForm(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean getMembresia() {
        return membresia;
    }

    public void setMembresia(boolean membresia) {
        this.membresia = membresia;
    }

    public String getDataCar() {
        return dataCar;
    }

    public void setDataCar(String dataCar) {
        this.dataCar = dataCar;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }
}

