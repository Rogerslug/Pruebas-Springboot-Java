package com.anydesk.demo.services;

import com.anydesk.demo.entities.Telefono;
import com.anydesk.demo.exception.ObjectNotFoundException;

import java.util.List;

public interface ITelefonoService {
    List<Telefono> obtenerTelefonos();

    Telefono buscarTelefonoPorId(Long id) throws ObjectNotFoundException;

    Telefono guardarTelefono(Telefono telefono);

    Telefono actualizarTelefono(Telefono telefono) throws ObjectNotFoundException;

    void  eliminarTelefono(Long id) throws ObjectNotFoundException;
}
