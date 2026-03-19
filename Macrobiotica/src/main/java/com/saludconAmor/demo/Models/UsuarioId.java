package com.saludconAmor.demo.Models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cedula;
    private Long idTipoUsuario;
}
