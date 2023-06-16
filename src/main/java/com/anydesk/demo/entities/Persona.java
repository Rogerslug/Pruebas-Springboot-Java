package com.anydesk.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; //Vacío o Null
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern; //Expresones Regulares
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private Long idPersona; //Long tipo de dato Id

    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacío")
    @Pattern(regexp = "[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*",
            message = "Nombre inválido")
    private String nombre;


    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacío")
    @Pattern(regexp = "[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*",
            message = "Apellido inválido")
    private String apellido;

    //Email String
    @Column(nullable = false)
    @NotBlank(message = "No puede ir vacío")
    @Pattern(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",
            message = "Email inválido")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "0{0,2}([\\+]?[\\d]{1,3} ?)?([\\(]([\\d]{2,3})[)] ?)?[0-9][0-9 \\-]{6,}( ?([xX]|([eE]xt[\\.]?)) ?([\\d]{1,5}))?",
            message = "Teléfono inválido")
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "No puede ir vacío")
    private Date fechaNacimiento;

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