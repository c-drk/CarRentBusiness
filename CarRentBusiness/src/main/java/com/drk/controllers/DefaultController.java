/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drk.controllers;

import com.drk.config.form.MainForm;
import com.drk.main.clases.Car;
import com.drk.main.clases.Cliente;
import com.drk.main.clases.Renta;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
/**
 *
 * @author drk
 */
@Controller
public class DefaultController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {       
       return "index";
    }    
    
    @RequestMapping("/submitForm")
    public @ResponseBody String loginDisponible(@RequestParam("nombre") String nombre) {
        return "hello "+nombre+" from controller";
    }    
     
    @RequestMapping(value = "/requestRent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateDisplay(@RequestBody MainForm form) throws JSONException{
        
        try {
            //Se encarga de tomar los datos del vehículo a rentar y los pasa al constructor de la clase respectiva
            //dataCar 60,Eveo,Sport,7
            String[]dataCar=form.getDataCar().split(",");
            int value=Integer.parseInt(dataCar[0]);
            String model=dataCar[1];
            String type=dataCar[2];
            int seguro=Integer.parseInt(dataCar[3]);
            
            Car car = new Car(value,model,type,seguro);
            //Se encarga de tomar los datos de la persona que va a rentar y los pasa al constructor de la clase respectiva
            //persona
            String nombre=form.getNombre();
            String apellido=form.getApellido();
            String cedula=form.getCedula();
            int edad=form.getEdad();
            boolean membresia=form.getMembresia();
            //constructor String nombre, String apellido, String cedula, int edad, boolean membresia
            Cliente client=new Cliente(nombre,apellido,cedula, edad, membresia);
            //Se encarga de tomar los dias de renta y los objetos de cliente y carro para construir el objeto renta
            //renta
            //constructor Renta(List<String> fechas, Cliente persona, Car carro)
            Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(form.getFechaI());
            Date fechaFin = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(form.getFechaF());
            Calendar c1 = Calendar.getInstance();
            c1.setTime(fechaInicio);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(fechaFin);
            List<String> listaFechas = new ArrayList<String>();
            String fecha;
            while (!c1.after(c2)) {
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                fecha = format1.format(c1.getTime());   
                listaFechas.add(fecha);
                c1.add(Calendar.DAY_OF_MONTH, 1);
            }
            
            Renta renta=new Renta(listaFechas, client, car);
            return renta.getJsonResponse();
        } catch (ParseException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
            return "exception from controller ";
        }
    }
    
}