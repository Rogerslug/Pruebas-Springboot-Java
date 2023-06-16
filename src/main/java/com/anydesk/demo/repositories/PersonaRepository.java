package com.anydesk.demo.repositories;

import com.anydesk.demo.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
