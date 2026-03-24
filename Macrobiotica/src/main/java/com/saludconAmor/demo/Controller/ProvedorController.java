package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.Provedor;
import com.saludconAmor.demo.Services.ProvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/provedores")
public class ProvedorController {

    @Autowired
    private ProvedorService service;

    @GetMapping
    public String listarProvedores(Model model) {
        model.addAttribute("provedores", service.listarTodos());
        model.addAttribute("provedor", new Provedor());
        return "provedores";
    }

    @PostMapping("/guardar")
    public String guardarProvedor(@ModelAttribute Provedor provedor, RedirectAttributes redirectAttributes) {
        service.guardar(provedor);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor guardado correctamente.");
        return "redirect:/provedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProvedor(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        service.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor eliminado correctamente.");
        return "redirect:/provedores";
    }
    
    @GetMapping("/obtener/{id}")
    @ResponseBody
    public Provedor obtenerProvedor(@PathVariable("id") Long id) {
        return service.buscarPorId(id).orElse(new Provedor());
    }
}
