package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.FacturacionProvedor;
import com.saludconAmor.demo.Services.FacturacionProvedorService;
import com.saludconAmor.demo.Repository.ProvedorRepository;
import com.saludconAmor.demo.Repository.ProductoRepository;
import com.saludconAmor.demo.Repository.EstadoRepository;
import com.saludconAmor.demo.Repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/facturas-proveedor")
public class FacturacionProvedorController {

    @Autowired
    private FacturacionProvedorService service;

    @Autowired
    private ProvedorRepository provedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("facturas", service.listarTodas());
        model.addAttribute("factura", new FacturacionProvedor()); // Para el form
        model.addAttribute("proveedores", provedorRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("estados", estadoRepository.findAll());
        model.addAttribute("tiposDocumento", tipoDocumentoRepository.findAll());
        return "facturas-provedor";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("factura") FacturacionProvedor factura) {
        service.guardar(factura);
        return "redirect:/facturas-proveedor";
    }

    @GetMapping("/editar/{id}")
    @ResponseBody
    public Optional<FacturacionProvedor> buscarFactura(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
