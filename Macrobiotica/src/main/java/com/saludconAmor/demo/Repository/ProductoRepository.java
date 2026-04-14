package com.saludconAmor.demo.Repository;

import com.saludconAmor.demo.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO FIDE_PRODUCTOS_TB (NOMBRE, PRECIO, DESCRIPCION, FECHA_VENCIMIENTO, FECHA_EMISION, STOCK, ID_ESTADO) " +
                   "VALUES (:nombre, :precio, :descripcion, :fechaVen, :fechaEmi, :stock, :estado)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, 
                          @Param("precio") BigDecimal precio, 
                          @Param("descripcion") String descripcion, 
                          @Param("fechaVen") Date fechaVen, 
                          @Param("fechaEmi") Date fechaEmi, 
                          @Param("stock") Long stock, 
                          @Param("estado") Long estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE FIDE_PRODUCTOS_TB SET NOMBRE = :nombre, PRECIO = :precio, DESCRIPCION = :descripcion, STOCK = :stock, ID_ESTADO = :estado " +
                   "WHERE CODIGO_PRODUCTO = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Long id,
                            @Param("nombre") String nombre, 
                            @Param("precio") BigDecimal precio, 
                            @Param("descripcion") String descripcion, 
                            @Param("stock") Long stock, 
                            @Param("estado") Long estado);
}
