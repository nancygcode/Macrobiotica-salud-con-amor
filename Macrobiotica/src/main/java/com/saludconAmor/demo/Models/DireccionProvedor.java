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
@Table(name = "FIDE_DIRECCIONES_PROVEDORES_TB")
public class DireccionProvedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODIGO_PROVEDOR")
    private Long codigoProvedor;

    @Column(name = "ID_PROVINCIA")
    private Long idProvincia;

    @Column(name = "ID_CANTON")
    private Long idCanton;

    @Column(name = "ID_ESTADO")
    private Long idEstado;
}
