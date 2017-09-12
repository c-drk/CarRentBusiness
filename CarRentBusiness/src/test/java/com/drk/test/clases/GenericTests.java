package com.drk.test.clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.drk.main.clases.Car;
import com.drk.main.clases.Persona;
import com.drk.main.clases.Cliente;
import com.drk.main.clases.Renta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author drk
 */
public class GenericTests {
    
    public GenericTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     
    @Test
    public void testEquality() {
        // valor - tipo -  modelo
        //(40USD/day for small cars, 60USD/day for sport cars, 100USD/day for SUV cars   
        //seguro 5 USD small, 7 USD sport, 10 USD suv
        assertEquals(new Car(40,"small","Dwarfy",5).getValue(), new Car(40,"small","Dwarfy",5).getValue(), 0.0);
        assertNotEquals(new Car(40,"small","Dwarfy",7).getValue(), new Car(60,"sport","Eveo",7).getValue(), 0.0);
        
        //assertNotEquals(new Persona("Carlos","Licto","1720820677",25).getCedula(), new Persona("Carlos","Licto","0500984751",32).getCedula(), 0.0);
        
        //Rentas
        //dias alquilados (domingo.lunes.martes)
        List<String> fechas = new ArrayList<>();
        fechas.add("2017-09-17");
        fechas.add("2017-09-18");
        fechas.add("2017-09-19");
        fechas.add("2017-09-20");
        fechas.add("2017-09-21");
        fechas.add("2017-09-22");
        //precios deseados
        List<Double> precios = new ArrayList<>();
        precios.add(40.0);
        precios.add(36.0);
        precios.add(36.0);
        //assertEquals(precios,new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy")).getPreciosPorDia());
        
        assertNotEquals(5,new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy",5)).getDescuentoRentDays());
        assertNotEquals(15,new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy",5)).getDescuentoRentDays());
        assertEquals(10,new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy",5)).getDescuentoRentDays());
      
        
    }
    
    @Test
    public void testBoolean () {
        assertTrue(new Cliente("Carlos","Licto","1720820677",25,true).esAdulto());
        assertFalse(new Cliente("Carlos","Licto","1720820677",17,false).esAdulto());
        
        assertTrue(new Cliente("Carlos","Licto","1720820677",25,true).esMiembro());
        assertFalse(new Cliente("Carlos","Licto","1720820677",17,false).esMiembro());
        
        //public Renta(List<String> fechas, Cliente persona, Car carro) 
        List<String> fechas = new ArrayList<>();
        fechas.add("2017-09-17");
        fechas.add("2017-09-18");
        fechas.add("2017-09-19");
        assertFalse(new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy",5)).isWeekday("2017-09-17"));
        assertTrue(new Renta(fechas,new Cliente("Carlos","Licto","1720820677",25,true),new Car(40,"small","Dwarfy",5)).isWeekday("2017-09-18"));
        
    }
}
