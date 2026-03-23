package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.FacturacionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FacturacionClienteRepository extends JpaRepository<FacturacionCliente, Long> {

    // Buscar por vendedor
    List<FacturacionCliente> findByCedulaVendedor(Long cedulaVendedor);

    // Buscar por cliente
    List<FacturacionCliente> findByCedulaCliente(Long cedulaCliente);

    // Buscar por estado
    List<FacturacionCliente> findByIdEstado(Long idEstado);

    // Total general de ventas
    @Query("SELECT COALESCE(SUM(f.total), 0) FROM FacturacionCliente f")
    BigDecimal sumTotalVentas();

    // Ventas agrupadas por vendedor: cedula, cantidad de facturas, total vendido
    @Query("SELECT f.cedulaVendedor, COUNT(f), SUM(f.total) " +
           "FROM FacturacionCliente f " +
           "GROUP BY f.cedulaVendedor " +
           "ORDER BY SUM(f.total) DESC")
    List<Object[]> ventasPorVendedor();

    // Productos más vendidos: codigo, cantidad total vendida
    @Query("SELECT f.codigoProducto, SUM(f.cantidadProducto) " +
           "FROM FacturacionCliente f " +
           "GROUP BY f.codigoProducto " +
           "ORDER BY SUM(f.cantidadProducto) DESC")
    List<Object[]> productosMasVendidos();
}
