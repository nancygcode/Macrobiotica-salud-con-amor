package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.FacturacionProvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionProvedorRepository extends JpaRepository<FacturacionProvedor, Long> {
}
