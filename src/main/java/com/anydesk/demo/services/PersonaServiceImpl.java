package com.anydesk.demo.services;

import com.anydesk.demo.entities.Persona;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{
//Hay dos maneras de inyectar
  //1
    //private final PersonaRepository personaRepository;
    //public PersonaServiceImpl(PersonaRepository personaRepository) {
    //    this.personaRepository = personaRepository;
    //}
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true) //No habrá delete, insert o update
    public List<Persona> obtenerPersonas(){
        //return personaRepository.findAll();
        return this.personaRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Persona buscarPersonaPorId(Long id) throws ObjectNotFoundException {
        //return this.personaRepository.findById(id).orElse(null);
        return this.buscadorPersona(id);
    }

    @Override
    @Transactional
    public Persona guardarPersona(Persona persona){
        return this.personaRepository.save(persona);
    }

    ///Actualizar porque habrá errores

    @Override //Práctica de ejemplo
    public List<Persona> buscarPersonaPorEdad(int edadMinima) {
        return null; //Acá se implementa la lógica de búsqueda por edad
    }

    @Override
    @Transactional
    public void eliminarPersona(Long id) throws ObjectNotFoundException {
            this.personaRepository.delete(this.buscadorPersona(id));
    }

    private Persona buscadorPersona(Long id) throws ObjectNotFoundException {
        Persona persona = this.personaRepository.findById(id).orElse(null);
        if(persona != null){
            return persona;
        }else {
            throw new ObjectNotFoundException("Persona con el id " + id + " no se encuentra en la base de datos");
        }
    }
}
