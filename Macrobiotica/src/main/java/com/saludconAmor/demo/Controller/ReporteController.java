package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/ventas-facturacion")
    public String verReporteVentasFacturacion(Model model) {
        Map<String, Object> datos = reporteService.obtenerDatosReporteGeneral();
        model.addAllAttributes(datos);
        return "reportes/ventas-facturacion";
    }
}
