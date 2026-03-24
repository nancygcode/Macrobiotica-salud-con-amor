package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.TipoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAsistenciaRepository extends JpaRepository<TipoAsistencia, Long> {
}
