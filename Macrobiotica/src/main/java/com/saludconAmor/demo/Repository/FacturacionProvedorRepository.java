package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.FacturacionProvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FacturacionProvedorRepository extends JpaRepository<FacturacionProvedor, Long> {

    @Query("SELECT COALESCE(SUM(f.pagoTotal), 0) FROM FacturacionProvedor f")
    BigDecimal obtenerTotalFacturacion();

    @Query("SELECT COUNT(f) FROM FacturacionProvedor f")
    long obtenerCantidadFacturas();

    @Query("SELECT p.nombreProvedor, COUNT(f), SUM(f.pagoTotal) FROM FacturacionProvedor f JOIN Provedor p ON f.codigoProvedor = p.codigoProvedor GROUP BY p.nombreProvedor ORDER BY SUM(f.pagoTotal) DESC")
    List<Object[]> obtenerGastoPorProvedor();
}
