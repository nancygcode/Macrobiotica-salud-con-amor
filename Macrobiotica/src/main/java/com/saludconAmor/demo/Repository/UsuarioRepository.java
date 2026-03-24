package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.Usuario;
import com.saludconAmor.demo.Models.UsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {

    // Solo empleados (ID_TIPO_USUARIO = 2)
    List<Usuario> findByIdTipoUsuario(Long idTipoUsuario);

    // Empleados activos
    List<Usuario> findByIdDepartamentoAndIdEstado(Long idDepartamento, Long idEstado);

    // Contar activos
    @Query("SELECT u.idDepartamento, COUNT(u) FROM Usuario u WHERE u.idEstado = 1 GROUP BY u.idDepartamento")
    List<Object[]> contarEmpleadosPorDepartamento();
}
