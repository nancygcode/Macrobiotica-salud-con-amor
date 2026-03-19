package com.saludconAmor.demo.Models;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FIDE_USUARIOS_TB")
@IdClass(UsuarioId.class)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CEDULA", unique = true)
    private Long cedula;

    @Id
    @Column(name = "ID_TIPO_USUARIO")
    private Long idTipoUsuario;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @Column(name = "APELLIDO_PATERNO", length = 100)
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO", length = 100)
    private String apellidoMaterno;

    @Column(name = "ID_ESTADO")
    private Long idEstado;

    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;
}
