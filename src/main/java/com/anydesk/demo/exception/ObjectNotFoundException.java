package com.anydesk.demo.exception;

//Reportador de error de los objetos que no se encuentran
//Polimorfismos
public class ObjectNotFoundException extends Exception{
    public ObjectNotFoundException(String mensaje){
        super(mensaje);
    }

}
