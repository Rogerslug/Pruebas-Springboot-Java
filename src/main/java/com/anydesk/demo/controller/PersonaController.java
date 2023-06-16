package com.anydesk.demo.controller;

import com.anydesk.demo.entities.Persona;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.services.IPersonaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
//@Controller sólo se usa cuando está el jpa
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    @GetMapping("/personas") //GET
    public ResponseEntity<List<Persona>> findAllPersonas(){
        return ResponseEntity.ok(this.personaService.obtenerPersonas()); //Se inyecta obtenerPersonas
    }

    @GetMapping("/persona/{id}") //GET by ID
    public ResponseEntity<?> findPersona(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok(this.personaService.buscarPersonaPorId(id));
    }

    @GetMapping("/personas/edad/{edadMinima}") //Práctica de ejemplo
    public ResponseEntity<List<Persona>> findPersonaByAge(@PathVariable int edadMinima) {
        List<Persona> personas = this.personaService.buscarPersonaPorEdad(edadMinima);
        return ResponseEntity.ok(personas);
    }


    @PostMapping("/persona") //POST singular
    public ResponseEntity<?> savePersona(@RequestBody @Valid Persona persona){
        //return ResponseEntity.ok(this.personaService.guardarPersona(persona));
        Map<String, Object> response = new HashMap<>();
        Persona personaNueva = this.personaService.guardarPersona(persona);

        response.put("mensaje", "Se ha guardado");
        response.put("persona", personaNueva);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    //Actualizar manejando errores

    @PutMapping("/persona/{id}") //PUT
    public ResponseEntity<?>updatePersona(@RequestBody @Valid Persona persona,@PathVariable Long id) throws ObjectNotFoundException {
        Map<String,Object> response = new HashMap<>();
        Persona personaActual= this.personaService.buscarPersonaPorId(id);

        personaActual.setNombre(persona.getNombre());
        personaActual.setApellido(persona.getApellido());
        personaActual.setTelefono(persona.getTelefono());
        personaActual.setEmail(persona.getEmail());
        personaActual.setFechaNacimiento(persona.getFechaNacimiento());

        Persona personaUpdate = this.personaService.guardarPersona(personaActual);

        response.put("mensaje", "Se ha actualizado");
        response.put("persona", personaUpdate);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/persona/{id}") //Delete
    public ResponseEntity<?> deletePersona(@PathVariable Long id) throws ObjectNotFoundException {
       /* return ResponseEntity.ok("Dato eliminado"); */
        Map<String, Object> response = new HashMap<>();
        this.personaService.eliminarPersona(id);
        response.put("mensaje", "Se ha eliminado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
