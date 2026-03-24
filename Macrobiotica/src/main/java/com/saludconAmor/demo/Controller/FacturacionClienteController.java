package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.FacturacionCliente;
import com.saludconAmor.demo.Services.FacturacionClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/facturas-cliente")
public class FacturacionClienteController {

    @Autowired
    private FacturacionClienteService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String listarFacturas(Model model) {
        model.addAttribute("facturas", service.listarTodas());
        model.addAttribute("factura", new FacturacionCliente());
        return "facturas-cliente";
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute FacturacionCliente factura, RedirectAttributes redirectAttributes) {
        service.guardar(factura);
        redirectAttributes.addFlashAttribute("mensaje", "Factura de cliente guardada correctamente.");
        return "redirect:/facturas-cliente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        service.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Factura de cliente eliminada correctamente.");
        return "redirect:/facturas-cliente";
    }
    
    @GetMapping("/obtener/{id}")
    @ResponseBody
    public FacturacionCliente obtenerFactura(@PathVariable("id") Long id) {
        return service.buscarPorId(id).orElse(new FacturacionCliente());
    }
}
