package com.anydesk.demo.services;

import com.anydesk.demo.entities.Persona;
import com.anydesk.demo.exception.ObjectNotFoundException;

import java.util.List;

public interface IPersonaService {
    List<Persona> obtenerPersonas();

    Persona buscarPersonaPorId(Long id) throws ObjectNotFoundException; //Práctica de ejemplo
    //
    Persona guardarPersona(Persona persona);

    List<Persona> buscarPersonaPorEdad(int edadMinima);
    void eliminarPersona(Long id) throws ObjectNotFoundException;
}
