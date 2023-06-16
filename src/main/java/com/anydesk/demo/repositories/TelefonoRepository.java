package com.anydesk.demo.repositories;

import com.anydesk.demo.entities.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonoRepository extends JpaRepository<Telefono,Long> {
}
