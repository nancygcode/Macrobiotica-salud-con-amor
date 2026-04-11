package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.Producto;
import com.saludconAmor.demo.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "producto/listado";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.obtenerTodosLosProductos().stream()
                .filter(p -> p.getCodigoProducto().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("producto", producto);
        return "producto/detalle";
    }

    @GetMapping("/inventario")
    public String verInventario(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "producto/inventario";
    }
}