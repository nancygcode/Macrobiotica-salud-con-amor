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
@Table(name = "FIDE_DEPARTAMENTOS_TB")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;

    @Column(name = "NOMBRE_DEPARTAMENTO", length = 80)
    private String nombreDepartamento;

    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;

    @Column(name = "ID_ESTADO")
    private Long idEstado;
}
