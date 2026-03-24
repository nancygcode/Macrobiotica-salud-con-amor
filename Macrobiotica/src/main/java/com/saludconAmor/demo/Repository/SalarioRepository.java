package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long> {

    @Query("SELECT SUM(s.salario) FROM Salario s")
    BigDecimal obtenerTotalNomina();

    @Query("SELECT AVG(s.salario) FROM Salario s")
    BigDecimal obtenerSalarioPromedio();
}
