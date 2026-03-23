package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.FacturacionCliente;
import com.saludconAmor.demo.Services.FacturacionClienteService;
import com.saludconAmor.demo.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
@RequestMapping("/admin/ventas")
public class VentasController {

    @Autowired
    private FacturacionClienteService ventasService;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public String panelVentas(Model model) {

        List<FacturacionCliente> todasLasVentas = ventasService.listarTodas();

        // Métricas del encabezado
        BigDecimal totalVentas = ventasService.obtenerTotalVentas();
        long cantidadFacturas = ventasService.obtenerCantidadFacturas();

        BigDecimal promedioVenta = BigDecimal.ZERO;
        if (cantidadFacturas > 0) {
            promedioVenta = totalVentas.divide(
                BigDecimal.valueOf(cantidadFacturas), 2, RoundingMode.HALF_UP
            );
        }

        // Tablas de resumen
        List<Object[]> ventasPorVendedor  = ventasService.obtenerVentasPorVendedor();
        List<Object[]> productosMasVendidos = ventasService.obtenerProductosMasVendidos();

        // Datos para filtros
        List<?> estados = estadoRepository.findAll();

        model.addAttribute("ventas",              todasLasVentas);
        model.addAttribute("totalVentas",         totalVentas);
        model.addAttribute("cantidadFacturas",    cantidadFacturas);
        model.addAttribute("promedioVenta",       promedioVenta);
        model.addAttribute("ventasPorVendedor",   ventasPorVendedor);
        model.addAttribute("productosMasVendidos",productosMasVendidos);
        model.addAttribute("estados",             estados);

        return "admin-ventas";
    }

    // Filtrar por vendedor
    @GetMapping("/vendedor/{cedula}")
    public String filtrarPorVendedor(@PathVariable Long cedula, Model model) {
        List<FacturacionCliente> ventas = ventasService.buscarPorVendedor(cedula);
        cargarModeloBase(model);
        model.addAttribute("ventas", ventas);
        model.addAttribute("filtroActivo", "Vendedor: " + cedula);
        return "admin-ventas";
    }

    // Filtrar por estado
    @GetMapping("/estado/{idEstado}")
    public String filtrarPorEstado(@PathVariable Long idEstado, Model model) {
        List<FacturacionCliente> ventas = ventasService.buscarPorEstado(idEstado);
        cargarModeloBase(model);
        model.addAttribute("ventas", ventas);
        model.addAttribute("filtroActivo", "Estado ID: " + idEstado);
        return "admin-ventas";
    }

    // Helper privado para recargar métricas sin duplicar código
    private void cargarModeloBase(Model model) {
        BigDecimal totalVentas     = ventasService.obtenerTotalVentas();
        long cantidadFacturas      = ventasService.obtenerCantidadFacturas();
        BigDecimal promedioVenta   = cantidadFacturas > 0
            ? totalVentas.divide(BigDecimal.valueOf(cantidadFacturas), 2, RoundingMode.HALF_UP)
            : BigDecimal.ZERO;

        model.addAttribute("totalVentas",          totalVentas);
        model.addAttribute("cantidadFacturas",     cantidadFacturas);
        model.addAttribute("promedioVenta",        promedioVenta);
        model.addAttribute("ventasPorVendedor",    ventasService.obtenerVentasPorVendedor());
        model.addAttribute("productosMasVendidos", ventasService.obtenerProductosMasVendidos());
        model.addAttribute("estados",              estadoRepository.findAll());
    }
}
