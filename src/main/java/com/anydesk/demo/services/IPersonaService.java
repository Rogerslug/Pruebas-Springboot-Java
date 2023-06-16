package com.anydesk.demo.services;

import com.anydesk.demo.entities.Persona;
import com.anydesk.demo.exception.ObjectNotFoundException;

import java.util.List;

public interface IPersonaService {
    List<Persona> obtenerPersonas();

    Persona buscarPersonaPorId(Long id) throws ObjectNotFoundException;

    Persona guardarPersona(Persona persona);

    //Práctica de ejemplo
    List<Persona> buscarPersonaPorEdad(int edadMinima);

    //List<Persona> buscarPersonaPorEdad(int edadMinima);//Práctica de ejemplo
    //
    void eliminarPersona(Long id) throws ObjectNotFoundException;
}
