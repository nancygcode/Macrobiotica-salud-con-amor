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
@Table(name = "FIDE_FACTURACION_CLIENTE_TB")
public class FacturacionCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_FACTURA")
    private Long numeroFactura;

    @Column(name = "CEDULA_CLIENTE", nullable = false)
    private Long cedulaCliente;

    @Column(name = "CODIGO_PRODUCTO", nullable = false)
    private Long codigoProducto;

    @Column(name = "CANTIDAD_PRODUCTO")
    private Long cantidadProducto;

    @Column(name = "SUBTOTAL", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "IVA", precision = 10, scale = 2)
    private BigDecimal iva;

    @Column(name = "TOTAL", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "FECHA_EMISION")
    private Date fechaEmision;

    @Column(name = "PAGO_RECIBIDO", precision = 10, scale = 2)
    private BigDecimal pagoRecibido;

    @Column(name = "CEDULA_VENDEDOR", nullable = false)
    private Long cedulaVendedor;

    @Column(name = "ID_ESTADO", nullable = false)
    private Long idEstado;
}
