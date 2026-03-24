package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Long> {

}
