package com.saludconAmor.demo.Models;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FIDE_CORREOS_TB")
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CEDULA")
    private Long cedula;

    @Column(name = "CORREO", length = 150)
    private String correo;

    @Column(name = "ES_PREFERIDO")
    private Long esPreferido;

    @Column(name = "ID_ESTADO")
    private Long idEstado;
}
