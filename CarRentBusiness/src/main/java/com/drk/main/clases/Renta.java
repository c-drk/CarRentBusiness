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
    private double subtotal;
    private double descuento;
    private double seguro;
    private Cliente persona;
    private Car carro;
    
    public Renta(List<String> fechas, Cliente persona, Car carro) {
        this.fechas = fechas;       
        this.persona=persona;
        this.carro=carro;
    }
    
    public List<Double> getPreciosPorDia(){
        //obtiene el valor del alquiler del carro
        final double carValue=carro.getValue();
        fechas.forEach(day -> {
            //si es dia laboral al valor de ese dia le resta un 10%, caso contrario no
            if(isWeekday(day)){
                precios.add(carValue-carValue*0.10);
            }
            else{
                precios.add(carValue);
            }
        });
        //retorna una lista con los precios por dia con el respectivo descuento
        return precios;
    }
    
    public double getTotal(){
        //Se verifica que sea adulto, caso contrario no realiza la operación
        if(this.persona.esAdulto()){
            this.subtotal=0;
            //acumula el precio invidivual de dias de renta previamente calculado,
            //es decir si es dia laboral menos 10% caso contrario precio estándar
            getPreciosPorDia().forEach(precio ->{
                this.subtotal+=precio;
            });     
            System.out.println("Subtotal: "+this.subtotal);
            this.total=this.subtotal;
            //Se obtiene el descuento por dias consecutivos de renta
            this.descuento=getDescuentoRentDays();
            System.out.println("Porcentaje de descuento: "+this.descuento);
            //Al total de renta se le quita el valor del descuento
            System.out.println("Descuento: "+this.total*(this.descuento/100));
            this.total-=this.total*(this.descuento/100);
            System.out.println("Total-Descuento: "+this.total);
            //si el cliente es miembro se descuenta un 5% adicional
            this.total=(this.persona.esMiembro()) ? this.total-(this.total*0.05) : this.total;
            System.out.println("Total-Membresia: "+this.total);
            //se toma la edad del cliente para aplicar el seguro, se obtiene el valor del seguro de 
            //la clase Car y se multiplica por el número de dias 
            this.seguro=(this.persona.getEdad()<25) ? 
                this.fechas.size()*this.carro.getSeguro() : 0;
            System.out.println("Seguro: "+this.seguro);
            //finalmente se añade el valor del seguro al total
            this.total+=this.seguro;
            System.out.println("Total: "+this.total);
        }
        else{
            this.total=0;
        }
        return this.total;
    }
    
    public boolean isWeekday(String day){        
        try {
            //crea una instancia de calendar, donde enviamos formateada la fecha en tipo String, para obtener un objeto 
            //Calendar con la fecha enviada por parámetro
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(sdf.parse(day));
           
            System.out.println("Fecha: "+calendar.getTime().toString());
            // dias de la semana
            String[] strDays = new String[]{"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};            
            
            System.out.println("La fecha: "+ day +" es : " + strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
            System.out.println("index array dias: "+(calendar.get(Calendar.DAY_OF_WEEK) - 1));
            //Obtenemos el dia de la semana del objeto Calendar que creamos y dependiendo del index que nos devuelva
            //podemos comparar con el array strDays que nos da una referencia de como están los dias ordenados en 
            //el objeto Calendar, con eso podemos saber si el dia es laboral o no, siendo inde 0 domingo y 6 sábado
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
    
    public int getDescuentoRentDays(){
        //toma el List de fechas y obtiene el tamaño del mismo, con ello se aplica el descuento por dias de renta
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
