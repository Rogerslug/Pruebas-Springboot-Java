package com.anydesk.demo.repositories;

import com.anydesk.demo.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion,Long> {
}
