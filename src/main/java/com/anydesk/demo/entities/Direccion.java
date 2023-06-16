package com.anydesk.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion", nullable = false)
    private Long idDireccion; // Long tipo de dato Id

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String municipio;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp // se va a crear al momento del registro
    private Date createAt;

    @Column(name = "update-at")
    private Date updateAt; //2023-06-15 13:21:15

    @PreUpdate
    public void update(){
        this.updateAt = new Date();
    }
}
