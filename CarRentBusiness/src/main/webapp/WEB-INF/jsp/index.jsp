<%-- 
    Document   : index
    Created on : 11/09/2017, 02:50:04 PM
    Author     : drk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
          
    </head>
    <body>    
        <div class="row">
            <h4>Formulario para alquiler de vehiculos</h4>
        </div>
        <div class="row">
            
            <form id="myEntryForm" name="myEntryForm" class="col s12" method="post" enctype="multipart/form-data">
                Cliente
                <hr>
                <div class="row">
                    <div class="input-field col s6 m3">
                        <i class="material-icons prefix">account_circle</i>
                        <input id="nombre" name="nombre" type="text" class="validate">
                        <label for="nombre">Nombre</label>
                    </div>
                    <div class="input-field col s6 m3">
                        <i class="material-icons prefix">account_circle</i>  
                        <input id="apellido" name="apellido" type="text" class="validate">
                        <label for="apellido">Apellido</label>
                    </div>
                    <div class="input-field col s6 m2">
                        <i class="material-icons prefix">chrome_reader_mode</i>    
                        <input id="cedula" name="cedula" type="text" class="validate">
                        <label for="cedula">Cédula</label>
                    </div>
                    <div class="input-field col s6 m2">
                        <i class="material-icons prefix">keyboard</i>    
                        <input id="edad" name="edad" type="text" class="validate">
                        <label for="edad">Edad</label>
                    </div>
                    <div style="padding-top: 2%;">
                        <input type="checkbox" class="filled-in" id="membresia" name="membresia"/>
                        <label for="membresia">¿Tienes membresía?</label>
                    </div>
                </div>
                Datos del vehículo
                <hr>
                <div class="row">
                    <div class="input-field col s6 m3">
                        <i class="material-icons prefix">directions_car</i>
                        <select id="dataCar" name="dataCar" class="validate">
                            <option value="" disabled selected>Seleccione</option>
                            <option value="40,Dwarfy,Small,5">Dwarfy</option>
                            <option value="40,Halfing,Small,5">Halfing</option>
                            <option value="60,Eveo,Sport,7">Eveo</option>
                            <option value="60,Cherato,Sport,7">Cherato</option>
                            <option value="100,Vitoro,Suv,10">Vitoro</option>
                            <option value="100,Exploring,Suv,10">Exploring</option>
                        </select>
                        <label>Modelo del vehículo:</label>
                    </div>
                    <div class="input-field col s6 m3">
                        <i class="material-icons prefix">date_range</i>
                        <label for="fechaI">Fecha inicio</label>
                        <input id="fechaI" name="fechaI" type="text" class="datepicker">
                    </div>
                    <div class="input-field col s6 m3">
                        <i class="material-icons prefix">date_range</i>
                        <label for="fechaF">Fecha de entrega</label>
                        <input id="fechaF" name="fechaF" type="text" class="datepicker">
                    </div>                    
                </div>                
                <!--<input id="submitJson" type="submit" value="Submit Form">-->
                <button id="submitJson" type="button" class="btn btn-primary">Enviar
                </button>         
            </form>
          </div>
          <div id="testdiv"></div>
    </body>
    <script>
        $(document).ready(function() {
            $('select').material_select();
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year
                format: 'dd-mm-yyyy' 
            });
            function valida_form()
            {
                var status=true;
                reg=/^[a-zA-Z]{3,}$/;
                if(!reg.test($('#nombre').val()))
                {
                  $('#nombre').addClass('invalid');
                  status=false;
                }
                else{
                  $('#nombre').removeClass('invalid');
                }
                if(!reg.test($('#apellido').val()))
                {
                  $('#apellido').addClass('invalid');
                  status=false;
                }  
                else{
                  $('#apellido').removeClass('invalid');
                }
                ced=/^\d{10}$/;
                if(!ced.test($('#cedula').val()))
                {
                  $('#cedula').addClass('invalid');
                  status=false;
                }  
                else{
                  $('#cedula').removeClass('invalid');
                }   
                ed=/^\d{2,2}$/;
                if(!ed.test($('#edad').val()))
                {
                  $('#edad').addClass('invalid');
                  status=false;
                }  
                else{
                  $('#edad').removeClass('invalid');
                }          
                car=/^.{5,}$/;
                if(!car.test($('#dataCar').val()))
                {
                  $('#dataCar').addClass('invalid');
                  status=false;
                }
                else{
                  $('#dataCar').removeClass('invalid');
                }
                fecha=/^\d{1,2}\s.{5,}$/;
                if(!fecha.test($('#fechaI').val()))
                {
                  $('#fechaI').addClass('invalid');
                  status=false;
                }
                else{
                  $('#fechaI').removeClass('invalid');
                }
                if(!fecha.test($('#fechaF').val()))
                {
                  $('#fechaF').addClass('invalid');
                  status=false;
                }
                else{
                  $('#fechaF').removeClass('invalid');
                }
                return status;
            }  
            $.fn.serializeObject = function()
            {
               var o = {};
               var a = this.serializeArray();
               $.each(a, function() {
                   if (o[this.name]) {
                       if (!o[this.name].push) {
                           o[this.name] = [o[this.name]];
                       }
                       o[this.name].push(this.value || '');
                   } else {
                       o[this.name] = this.value || '';
                   }
               });
               return o;
            };
            $('#submitJson').click(function() {
                if(valida_form()){                    
                    alert("Generando Json...");
                    /*
                    $.ajax({
                        contentType : 'application/json; charset=utf-8',
                        type: "POST",
                        url: "CarRentBusiness/submitForm/?nombre="+$('#nombre').val(),
                        //dataType : 'json',
                        //data: $("#myEntryForm").serialize(),
                        //data: "nombre"+ $('#nombre').val(),
                        success : function(response){
                            alert("Response: Name: "+response);
                        },
                        error : function(e){
                            alert("Error generando Json "+e);
                            console.log(e);
                        }
                    });*/
                    console.log( JSON.stringify($("#myEntryForm").serializeObject()));
                    $("#testdiv").text(JSON.stringify($("#myEntryForm").serializeObject()));
                    $.ajax({
                        //data: JSON.stringify({'diagonal':"sss"})
                        contentType : 'application/json; charset=utf-8',
                        type: "POST",
                        url: "CarRentBusiness/updateDisplay",
                        dataType : 'json',
                        data: JSON.stringify($("#myEntryForm").serializeObject()),
                        success : function(response){
                            alert(response);
                        },
                        error : function(e){
                            alert("Error generando Json "+e);
                            console.log(e);
                        }
                    });
                }
                else{
                    alert("Ingrese todos los campos");
                }
            });
        });
    </script>
</html>
