package com.saludconAmor.demo.Controller;

import com.saludconAmor.demo.Models.Asistencia;
import com.saludconAmor.demo.Models.Usuario;
import com.saludconAmor.demo.Services.AsistenciaService;
import com.saludconAmor.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
@RequestMapping("/admin/rrhh")
public class RecursosHumanosController {

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SalarioRepository salarioRepository;

    @Autowired
    private TipoAsistenciaRepository tipoAsistenciaRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    // ── Vista principal ──────────────────────────────────────────────────────
    @GetMapping
    public String panelRRHH(Model model) {
        cargarModeloBase(model);
        model.addAttribute("asistencias", asistenciaService.listarTodas());
        return "admin-rrhh";
    }

    // ── Filtrar por empleado ─────────────────────────────────────────────────
    @GetMapping("/empleado/{cedula}")
    public String filtrarPorEmpleado(@PathVariable Long cedula, Model model) {
        cargarModeloBase(model);
        model.addAttribute("asistencias", asistenciaService.buscarPorEmpleado(cedula));
        model.addAttribute("filtroActivo", "Empleado: " + cedula);
        return "admin-rrhh";
    }

    // ── Filtrar por tipo de asistencia ───────────────────────────────────────
    @GetMapping("/tipo/{idTipo}")
    public String filtrarPorTipo(@PathVariable Long idTipo, Model model) {
        cargarModeloBase(model);
        model.addAttribute("asistencias", asistenciaService.buscarPorTipo(idTipo));
        model.addAttribute("filtroActivo", "Tipo de asistencia: " + idTipo);
        return "admin-rrhh";
    }

    // ── Helper: carga métricas y listas de apoyo ─────────────────────────────
    private void cargarModeloBase(Model model) {
        // KPIs
        long totalEmpleados      = usuarioRepository.findByIdTipoUsuario(2L).size();
        long totalRegistros      = asistenciaService.obtenerTotalRegistros();
        BigDecimal totalNomina   = salarioRepository.obtenerTotalNomina();
        BigDecimal promedioSalario = salarioRepository.obtenerSalarioPromedio();

        if (totalNomina   == null) totalNomina   = BigDecimal.ZERO;
        if (promedioSalario == null) promedioSalario = BigDecimal.ZERO;

        // Tablas de resumen
        List<Object[]> registrosPorEmpleado = asistenciaService.obtenerRegistrosPorEmpleado();
        List<Object[]> registrosPorTipo     = asistenciaService.obtenerRegistrosPorTipo();
        List<Usuario>  empleados            = usuarioRepository.findByIdTipoUsuario(2L);

        // Listas para filtros
        List<?> tipos   = tipoAsistenciaRepository.findAll();
        List<?> estados = estadoRepository.findAll();

        model.addAttribute("totalEmpleados",      totalEmpleados);
        model.addAttribute("totalRegistros",       totalRegistros);
        model.addAttribute("totalNomina",          totalNomina);
        model.addAttribute("promedioSalario",      promedioSalario.setScale(2, RoundingMode.HALF_UP));
        model.addAttribute("registrosPorEmpleado", registrosPorEmpleado);
        model.addAttribute("registrosPorTipo",     registrosPorTipo);
        model.addAttribute("empleados",            empleados);
        model.addAttribute("tipos",                tipos);
        model.addAttribute("estados",              estados);
    }
}
