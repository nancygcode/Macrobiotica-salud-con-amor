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
@Table(name = "FIDE_FACTURACION_PROVEDORES_TB")
public class FacturacionProvedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_FACTURA")
    private Long numeroFactura;

    @Column(name = "FECHA_COMPRA")
    private Date fechaCompra;

    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;

    @Column(name = "PAGO_TOTAL", precision = 10, scale = 2)
    private BigDecimal pagoTotal;

    @Column(name = "CLAVE_HACIENDA")
    private Long claveHacienda;

    @Column(name = "DESCRIPCION", length = 400)
    private String descripcion;

    @Column(name = "ID_ESTADO", nullable = false)
    private Long idEstado;

    @Column(name = "CODIGO_PROVEDOR", nullable = false)
    private Long codigoProvedor;

    @Column(name = "ID_PRODUCTO", nullable = false)
    private Long idProducto;

    @Column(name = "ID_TIPO_DOCUMENTO", nullable = false)
    private Long idTipoDocumento;
}
