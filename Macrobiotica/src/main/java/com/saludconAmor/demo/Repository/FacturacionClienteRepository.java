package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.FacturacionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FacturacionClienteRepository extends JpaRepository<FacturacionCliente, Long> {

    @Query("SELECT COALESCE(SUM(f.total), 0) FROM FacturacionCliente f")
    BigDecimal obtenerTotalVentas();

    @Query("SELECT COUNT(f) FROM FacturacionCliente f")
    long obtenerCantidadFacturas();

    @Query("SELECT f.cedulaVendedor, COUNT(f), SUM(f.total) FROM FacturacionCliente f GROUP BY f.cedulaVendedor ORDER BY SUM(f.total) DESC")
    List<Object[]> obtenerVentasPorVendedor();

    @Query(value = "SELECT COALESCE(p.NOMBRE, 'Prod ID: ' || f.CODIGO_PRODUCTO), SUM(f.CANTIDAD_PRODUCTO) FROM FIDE_FACTURACION_CLIENTE_TB f LEFT JOIN FIDE_PRODUCTOS_TB p ON f.CODIGO_PRODUCTO = p.CODIGO_PRODUCTO GROUP BY p.NOMBRE, f.CODIGO_PRODUCTO ORDER BY SUM(f.CANTIDAD_PRODUCTO) DESC", nativeQuery = true)
    List<Object[]> obtenerProductosMasVendidos();

    List<FacturacionCliente> findByCedulaVendedor(Long cedulaVendedor);

    List<FacturacionCliente> findByIdEstado(Long idEstado);
}
