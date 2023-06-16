package com.anydesk.demo.services;

import com.anydesk.demo.entities.Direccion;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DireccionServiceImpl implements IDireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Direccion> obtenerDirecciones() {
        return this.direccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Direccion buscarDireccionPorId(Long id) throws ObjectNotFoundException {
        return this.buscadorDireccion(id);
    }

    @Override
    @Transactional
    public Direccion guardarDireccion(Direccion direccion){
        return this.direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public Direccion actualizarDireccion(Direccion direccion) throws ObjectNotFoundException {
        if(direccion.getIdDireccion() != null && this.direccionRepository.existsById(direccion.getIdDireccion())) {
            Direccion direccionExistente = this.direccionRepository.findById(direccion.getIdDireccion()).orElseThrow(() -> new ObjectNotFoundException("Direccion con el id " + direccion.getIdDireccion() + " no se encuentra en la base de datos"));
            direccionExistente.setCalle(direccion.getCalle());
            direccionExistente.setMunicipio(direccion.getMunicipio());
            return this.direccionRepository.save(direccionExistente);
        } else {
            throw new ObjectNotFoundException("Direccion con el id " + direccion.getIdDireccion() + " no se encuentra en la base de datos");
        }
    }

    @Override
    @Transactional
    public void eliminarDireccion(Long id) throws ObjectNotFoundException {
        this.direccionRepository.delete(this.buscadorDireccion(id));
    }

    private Direccion buscadorDireccion(Long id) throws ObjectNotFoundException {
        Direccion direccion = this.direccionRepository.findById(id).orElse(null);
        if(direccion != null){
            return direccion;
        } else {
            throw new ObjectNotFoundException("Dirección con el id " + id + " no se encuentra en la base de datos");
        }
    }
}