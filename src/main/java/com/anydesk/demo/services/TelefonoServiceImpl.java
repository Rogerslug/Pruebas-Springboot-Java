package com.anydesk.demo.services;

import com.anydesk.demo.entities.Telefono;
import com.anydesk.demo.exception.ObjectNotFoundException;
import com.anydesk.demo.repositories.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefonoServiceImpl implements ITelefonoService{
    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Telefono> obtenerTelefonos() {
        return this.telefonoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Telefono buscarTelefonoPorId(Long id) throws ObjectNotFoundException {
        return this.buscadorTelefono(id);
    }

    @Override
    @Transactional
    public Telefono guardarTelefono(Telefono telefono) {
        return this.telefonoRepository.save(telefono);
    }

    @Override
    @Transactional
    public Telefono actualizarTelefono(Telefono telefono) throws ObjectNotFoundException {
        if (telefono.getIdTelefono() !=  null && this.telefonoRepository.existsById(telefono.getIdTelefono())) {
            Telefono telefonoExistente = this.telefonoRepository.findById(telefono.getIdTelefono()).orElseThrow(() -> new ObjectNotFoundException("Telefono con el id " + telefono.getIdTelefono() + " no se encuentra en la vase de datos"));
            telefonoExistente.setNumero(telefono.getNumero());
            return this.telefonoRepository.save(telefonoExistente);
        } else {
            throw new ObjectNotFoundException("El telefono con el id " + telefono.getIdTelefono() + " no se encuentra en la base de datos");
        }
    }

    @Override
    @Transactional
    public void eliminarTelefono(Long id) throws ObjectNotFoundException {
        this.telefonoRepository.delete(this.buscadorTelefono(id));
    }

    private Telefono buscadorTelefono(Long id) throws ObjectNotFoundException {
        Telefono telefono = this.telefonoRepository.findById(id).orElse(null);
        if(telefono != null){
            return telefono;
        } else {
            throw new ObjectNotFoundException("Telefono con el id " + id + " no se encuentra en la base de datos");
        }
    }
}
