package com.anydesk.demo.controller;

import com.anydesk.demo.entities.Direccion;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.services.DireccionServiceImpl;
import com.anydesk.demo.services.IDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DireccionController {
    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/direcciones") //GET
    public ResponseEntity<List<Direccion>> obtenerDirecciones() {
        List<Direccion> direcciones = this.direccionService.obtenerDirecciones();
        return new ResponseEntity<>(direcciones, HttpStatus.OK);
    }

    @GetMapping("/direccion/{id}") //GET a través de id
    public ResponseEntity<Direccion> buscarDireccionPorId(@PathVariable Long id) throws ObjectNotFoundException {
        Direccion direccion = this.direccionService.buscarDireccionPorId(id);
        return new ResponseEntity<>(direccion, HttpStatus.OK);
    }
    @PostMapping("/direccion") //POST
    public ResponseEntity<Direccion> guardarDireccion(@RequestBody Direccion direccion) {
        Direccion nuevaDireccion = this.direccionService.guardarDireccion(direccion);
        return new ResponseEntity<>(nuevaDireccion, HttpStatus.CREATED);
    }
    @PutMapping("/direccion/{id}") //PUT
    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Long id, @RequestBody Direccion direccion) throws ObjectNotFoundException {
        direccion.setIdDireccion(id);
        Direccion direccionActualizada = this.direccionService.actualizarDireccion(direccion);
        return new ResponseEntity<>(direccionActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/direccion/{id}") //DELETE
    public ResponseEntity<?> eliminarDireccion(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();
        this.direccionService.eliminarDireccion(id);
        response.put("mensaje", "Se ha eliminado exitosamente");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}