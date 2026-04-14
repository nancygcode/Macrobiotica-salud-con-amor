package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.Producto;
import com.saludconAmor.demo.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
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
        Producto producto = productoService.buscarPorId(id).orElse(null);
        model.addAttribute("producto", producto);
        return "producto/detalle";
    }

    @GetMapping("/inventario")
    public String verInventario(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("producto", new Producto());
        return "producto/inventario";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
        // Inicializamos fechas si es necesario
        if (producto.getFechaEmision() == null) {
            producto.setFechaEmision(new Date());
        }
        if (producto.getFechaVencimiento() == null) {
            // Fecha por defecto: 1 año después
            Date now = new Date();
            producto.setFechaVencimiento(new Date(now.getTime() + (1000L * 60 * 60 * 24 * 365)));
        }

        try {
            productoService.guardar(producto);
            redirectAttributes.addFlashAttribute("mensaje", "Producto guardado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar el producto: " + e.getMessage());
        }
        
        return "redirect:/producto/inventario";
    }

    @GetMapping("/obtener/{id}")
    @ResponseBody
    public Producto obtenerProducto(@PathVariable("id") Long id) {
        return productoService.buscarPorId(id).orElse(new Producto());
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productoService.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado correctamente.");
        return "redirect:/producto/inventario";
    }
}