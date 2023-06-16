package com.anydesk.demo.services;

import com.anydesk.demo.entities.Direccion;
import com.anydesk.demo.exception.ObjectNotFoundException;

import java.util.List;

public interface IDireccionService {
    List<Direccion> obtenerDirecciones();

    Direccion buscarDireccionPorId(Long id) throws ObjectNotFoundException;

    Direccion guardarDireccion(Direccion direccion);

    Direccion actualizarDireccion(Direccion direccion) throws ObjectNotFoundException;

    void eliminarDireccion(Long id) throws ObjectNotFoundException;
}
