package com.saludconAmor.demo.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FIDE_SALARIO_TB")
public class Salario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CEDULA")
    private Long cedula;

    @Column(name = "SALARIO", precision = 10, scale = 2)
    private BigDecimal salario;
}
