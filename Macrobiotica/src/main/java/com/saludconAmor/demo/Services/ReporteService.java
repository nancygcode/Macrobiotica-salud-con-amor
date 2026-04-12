package com.saludconAmor.demo.Services;

import com.saludconAmor.demo.Repository.FacturacionClienteRepository;
import com.saludconAmor.demo.Repository.FacturacionProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteService {

    @Autowired
    private FacturacionClienteRepository clienteRepo;

    @Autowired
    private FacturacionProvedorRepository provedorRepo;

    public Map<String, Object> obtenerDatosReporteGeneral() {
        Map<String, Object> reportData = new HashMap<>();

        // Ventas (Clientes)
        BigDecimal totalVentas = clienteRepo.obtenerTotalVentas();
        if (totalVentas == null) totalVentas = BigDecimal.ZERO;
        reportData.put("totalVentas", totalVentas);
        reportData.put("cantFacturasVentas", clienteRepo.obtenerCantidadFacturas());
        reportData.put("ventasPorVendedor", clienteRepo.obtenerVentasPorVendedor());
        reportData.put("productosMasVendidos", clienteRepo.obtenerProductosMasVendidos());

        // Facturacion (Proveedores)
        BigDecimal totalGastos = provedorRepo.obtenerTotalFacturacion();
        if (totalGastos == null) totalGastos = BigDecimal.ZERO;
        reportData.put("totalGastoProvedores", totalGastos);
        reportData.put("cantFacturasProvedores", provedorRepo.obtenerCantidadFacturas());
        reportData.put("gastoPorProvedor", provedorRepo.obtenerGastoPorProvedor());

        // Balance Neto
        reportData.put("balanceNeto", totalVentas.subtract(totalGastos));

        return reportData;
    }
}
