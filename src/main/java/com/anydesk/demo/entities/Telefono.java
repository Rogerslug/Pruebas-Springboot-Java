package com.anydesk.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "telefonos")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono", nullable = false)
    private Long idTelefono; // Long tipo de dato Id

    @Column(nullable = false)
    @Pattern(regexp = "0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?",
            message = "Número inválido")
    private String numero;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp // se va a crear al momento del registro
    private Date createAt;

    @Column(name = "update-at")
    private Date updateAt;

    @PreUpdate
    public void update(){
        this.updateAt = new Date();
    }
}
