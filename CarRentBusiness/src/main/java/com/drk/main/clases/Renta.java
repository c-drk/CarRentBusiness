/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drk.main.clases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drk
 */
public class Renta {
    private List<String> fechas = new ArrayList<>();
    private List<Double> precios = new ArrayList<>();
    private double total;
    private double descuento;
    private Cliente persona;
    private Car carro;
    
    public Renta(List<String> fechas, Cliente persona, Car carro) {
        this.fechas = fechas;       
        this.persona=persona;
        this.carro=carro;
    }
    
    public List<Double> getPreciosPorDia(){
        final double carValue=carro.getValue();
        fechas.forEach(day -> {
            if(isWeekday(day)){
                precios.add(carValue-carValue*0.10);
            }
            else{
                precios.add(carValue);
            }
        });
        return precios;
    }
    
    public double getTotal(){
        getPreciosPorDia();
        descuentoRentDays();
        return 0.0;
    }
    
    public boolean isWeekday(String day){        
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(sdf.parse(day));
           
            System.out.println("Fecha: "+calendar.getTime().toString());
            // dias de la semana
            String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};            
            
            System.out.println("La fecha: "+ day +" es : " + strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
            System.out.println("index array dias: "+(calendar.get(Calendar.DAY_OF_WEEK) - 1));
            switch((calendar.get(Calendar.DAY_OF_WEEK) - 1)){
                case 0: case 6:
                    System.out.println("Es dia laboral false");
                    return false;
                default:
                    System.out.println("Es dia laboral true");
                    return true;
            }
        } 
        catch (ParseException ex) {
            Logger.getLogger(Renta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private int descuentoRentDays(){
        int numdays=this.fechas.size();
        switch(numdays){
            case 0: case 1: case 2:
                return 0;
            case 3: case 4: case 5:
                return 5;                
            case 6: case 7: case 8: case 9: case 10:
                return 10;
            default:
                return 15;
        }
    }
}
