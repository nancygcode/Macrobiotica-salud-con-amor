package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Models.Producto;
import com.saludconAmor.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public void guardar(Producto producto) {
        if (producto.getCodigoProducto() == null || producto.getCodigoProducto() == 0) {
            // Inserción nativa
            productoRepository.insertarProducto(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getFechaVencimiento(),
                producto.getFechaEmision(),
                producto.getStock(),
                producto.getIdEstado()
            );
        } else {
            // Actualización nativa
            productoRepository.actualizarProducto(
                producto.getCodigoProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getStock(),
                producto.getIdEstado()
            );
        }
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}