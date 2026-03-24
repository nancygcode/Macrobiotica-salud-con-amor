package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    List<Asistencia> findByCedula(Long cedula);

    List<Asistencia> findByIdTipoAsistencia(Long idTipoAsistencia);

    List<Asistencia> findByIdEstado(Long idEstado);

    // Total de registros por empleado
    @Query("SELECT a.cedula, COUNT(a) FROM Asistencia a GROUP BY a.cedula ORDER BY COUNT(a) DESC")
    List<Object[]> obtenerRegistrosPorEmpleado();

    // Conteo por tipo de asistencia
    @Query("SELECT a.idTipoAsistencia, COUNT(a) FROM Asistencia a GROUP BY a.idTipoAsistencia")
    List<Object[]> obtenerRegistrosPorTipo();
}
