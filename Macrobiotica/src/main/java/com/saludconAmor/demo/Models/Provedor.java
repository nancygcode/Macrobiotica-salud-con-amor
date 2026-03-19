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
@Table(name = "FIDE_PROVEDORES_TB")
public class Provedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_PROVEDOR")
    private Long codigoProvedor;

    @Column(name = "NOMBRE_PROVEDOR", length = 250)
    private String nombreProvedor;

    @Column(name = "ID_ESTADO")
    private Long idEstado;
}
