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
@Table(name = "FIDE_TELEFONOS_PROVEDOR_TB")
public class TelefonoProvedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_PROVEDOR")
    private Long codigoProvedor;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Column(name = "ES_PREFERIDO")
    private Long esPreferido;

    @Column(name = "ID_ESTADO")
    private Long idEstado;
}
