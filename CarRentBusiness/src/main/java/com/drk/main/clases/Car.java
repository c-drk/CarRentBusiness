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
public class Car {
    
    private int value;
    private String model;
    private String type;
    
    public Car(int value, String model, String type) {
        this.value = value;
        this.model = model;
        this.type = type;
    }
    
    public int getValue(){
        System.out.println("Valor: "+this.value);
        return this.value;
    }
    
    public String getModel(){
        System.out.println("Modelo: "+this.model);
        return this.model;
    }
    
    public String getType(){
        System.out.println("Tipo: "+this.type);
        return this.type;
    }
    
}
