package com.saludconAmor.demo.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FIDE_ASISTENCIA_TB")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASISTENCIA")
    private Long idAsistencia;

    @Column(name = "CEDULA", nullable = false)
    private Long cedula;

    @Column(name = "ENTRADA", nullable = false)
    private Timestamp entrada;

    @Column(name = "SALIDA", nullable = false)
    private Timestamp salida;

    @Column(name = "ID_TIPO_ASISTENCIA", nullable = false)
    private Long idTipoAsistencia;

    @Column(name = "ID_ESTADO", nullable = false)
    private Long idEstado;
}
