package com.saludconAmor.demo.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FIDE_PRODUCTOS_TB")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_PRODUCTO")
    private Long codigoProducto;

    @Column(name = "NOMBRE", length = 250)
    private String nombre;

    @Column(name = "PRECIO", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "DESCRIPCION", length = 300)
    private String descripcion;

    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "STOCK", nullable = false)
    private Long stock;

    @Column(name = "ID_ESTADO", nullable = false)
    private Long idEstado;
}
