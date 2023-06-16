package com.anydesk.demo.controller;

import com.anydesk.demo.entities.Telefono;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.services.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelefonoController {
    @Autowired
    private ITelefonoService telefonoService;

    @GetMapping("/telefonos") //GET
    public ResponseEntity<List<Telefono>> obtenerTelefonos() {
        List<Telefono> telefonos = this.telefonoService.obtenerTelefonos();
        return new ResponseEntity<>(telefonos, HttpStatus.OK);
    }

    @GetMapping("/telefono/{id}") //GET por Id
    public ResponseEntity<Telefono> buscarTelefonoPorId(@PathVariable Long id) throws ObjectNotFoundException {
        Telefono telefono = this.telefonoService.buscarTelefonoPorId(id);
        return new ResponseEntity<>(telefono, HttpStatus.OK);
    }

    @PostMapping("/telefono") //POST
    public ResponseEntity<Telefono> guardarTelefono(@RequestBody Telefono telefono) {
        Telefono nuevoTelefono = this.telefonoService.guardarTelefono(telefono);
        return new ResponseEntity<>(nuevoTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/telefono/{id}") //PUT
    public ResponseEntity<Telefono> actualizarTelefono(@PathVariable Long id, @RequestBody Telefono telefono) throws ObjectNotFoundException {
        telefono.setIdTelefono(id);
        Telefono telefonoActualizado = this.telefonoService.actualizarTelefono(telefono);
        return new ResponseEntity<>(telefonoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/telefono/{id}") //DELETE
    public ResponseEntity<?> eliminarTelefono(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();
        this.telefonoService.eliminarTelefono(id);
        response.put("mensaje", "Se ha eliminado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
